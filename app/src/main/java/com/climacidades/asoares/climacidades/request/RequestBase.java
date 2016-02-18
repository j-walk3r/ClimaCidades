package com.climacidades.asoares.climacidades.request;

import android.os.AsyncTask;

import com.climacidades.asoares.climacidades.utility.Constantes;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asoares on 17/02/16.
 */
public class RequestBase extends AsyncTask<RequestBase, Object, String> {

    public RequestBase() {
    }

    @Override
    protected String doInBackground(RequestBase... params)
    {
        try
        {
            return sendGetRequest();
        }
        catch (Exception e)
        {
            return "error";
        }
    }


    private String sendGetRequest()
    {
        String retorno = "";
        URL url;

        try
        {
            url = new URL(Constantes.getURLAPICLIMA());

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            String jsonStr = convertStreamToString(in, "UTF-8");

            retorno = jsonStr;

            return retorno;
        }
        catch (Exception e)
        {
            return "error";
        }

    }

    private static String convertStreamToString(InputStream is, String enc) throws UnsupportedEncodingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, enc));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try
        {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
