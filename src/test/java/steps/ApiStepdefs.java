package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import util.jsonUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiStepdefs {
    String baseURL = "https://api.trademe.co.nz/v1/";
    MutablePicoContainer pico = new DefaultPicoContainer();
    @Given("I build the Public GET API Request for {} to return {} response")
    public void iBuildTheBasicPublicGETAPIRequest(String serviceName, String fileFormat) throws IOException {
        StringBuffer urlString = new StringBuffer();
        urlString
                .append(baseURL)
                .append(serviceName)
                .append(".")
                .append(fileFormat);
        URL url = new URL(urlString.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        pico.addComponent(conn);
    }

    @When("I call the given method")
    public void iCallTheGivenMethod() throws IOException {
        HttpURLConnection conn = pico.getComponent(HttpURLConnection.class);
        Assert.assertEquals(200, conn.getResponseCode());
    }

    @Then("the {} response has the expected data: {} given by the Service {}")
    public void theResponseHasTheExpectedData(String responseFormat, String data, String serviceName) throws IOException {
        HttpURLConnection conn = pico.getComponent(HttpURLConnection.class);
        java.io.InputStream istrm = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(istrm);
        java.io.BufferedReader br = new java.io.BufferedReader(isr);
        String line = null;
        String response = "";
        while ((line = br.readLine()) != null) {
            response = response.concat(line);
        }
        if (responseFormat.equalsIgnoreCase("json")){
            if (serviceName.equalsIgnoreCase("Charities")){
                JSONArray charityList = new JSONArray(response);
                JSONObject charity = jsonUtil.getJSONObjectFromJSONArray(charityList,
                        "Description", data);
                Assert.assertEquals(data, charity.getString("Description").trim());
            } else if (serviceName.equalsIgnoreCase("Categories/UsedCars")){
                JSONObject j = new JSONObject(response);
                JSONArray carSubcategories = j.getJSONArray("Subcategories");
                JSONObject car = jsonUtil.getJSONObjectFromJSONArray(carSubcategories, "Name", data);
                Assert.assertEquals(data, car.getString("Name").trim());
            }
        } else if (responseFormat.equalsIgnoreCase("xml"))
            throw new UnsupportedOperationException("XML Verification Not Implemented");
    }
}
