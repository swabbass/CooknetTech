package ward.net.cooknettech.API;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import ward.net.cooknettech.MainApp;
import ward.net.cooknettech.Models.FacebookUser;
import ward.net.networkcorew.Handlers.BaseResponse;

/**
 * Created by ward on 5/8/2015.
 */
public final class Requests {


    private static final String TAG="API_REQUESTS";

    public static void sendRegFacebook(FacebookUser facebookUser,BaseResponse<String> baseResponse){

       final String  json= MainApp.gson.toJson(facebookUser);
        try {
            final JSONObject jsonObject=new JSONObject(json);
            Log.d(TAG,jsonObject.toString());
            StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST, Routes.FACEBOOK, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.d(TAG,response==null?"null respons":response.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,error==null?"null respons":error.getMessage());

                }
            }){
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonObject.toString().getBytes();
                }

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }
            };
            jsonObjectRequest.setShouldCache(false);
            jsonObjectRequest.setRetryPolicy(new RetryPolicy() {
                @Override
                public int getCurrentTimeout() {
                    return 15000;
                }

                @Override
                public int getCurrentRetryCount() {
                    return 0;
                }

                @Override
                public void retry(VolleyError error) throws VolleyError {

                }
            });

            MainApp.network.addToRequestQueue(jsonObjectRequest);

        } catch (JSONException e) {

        }
    }
}
