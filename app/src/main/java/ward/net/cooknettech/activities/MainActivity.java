package ward.net.cooknettech.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import ward.net.cooknettech.API.Requests;
import ward.net.cooknettech.Models.FacebookUser;
import ward.net.cooknettech.Models.Gender;
import ward.net.cooknettech.R;
import ward.net.cooknettech.Utilites;
import ward.net.networkcorew.Handlers.BaseResponse;


public class MainActivity extends ActionBarActivity {

    private LoginButton loginButton;
    CallbackManager callbackManager;
    Profile profile;
    private ProfileTracker mProfileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();

        Utilites.printHashKey(this);
        final TextView textView= (TextView) findViewById(R.id.textview);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile ","email");
        if(facebookPost()){
            profile=Profile.getCurrentProfile();
            if(profile!=null){

            }
        }
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                final AccessToken accessToken= loginResult.getAccessToken();

                mProfileTracker = new ProfileTracker() {
                    @Override
                    protected void onCurrentProfileChanged(Profile old, Profile current) {
                    profile=current;
                        mProfileTracker.stopTracking();
                        if(profile!=null){
                            GraphRequest request = GraphRequest.newMeRequest(
                                    accessToken,
                                    new GraphRequest.GraphJSONObjectCallback() {
                                        @Override
                                        public void onCompleted(
                                                JSONObject object,
                                                GraphResponse response) {
                                            FacebookUser facebookUser= null;
                                            try {
                                                int gender=object.getString("gender").contains("male")?Gender.MALE:Gender.FEMALE;
                                                facebookUser = new FacebookUser(profile.getName(),profile.getId(),object.getString("email"), gender,profile.getProfilePictureUri(250,250).toString(),accessToken.getToken());
                                            } catch (JSONException e) {

                                            }
                                            Requests.sendRegFacebook(facebookUser, new BaseResponse<String>() {
                                                @Override
                                                public void onSuccess(String data) {
                                                    try {
                                                        JSONObject jsonObject=new JSONObject(data);
                                                        String local=jsonObject.getString("token");

                                                    } catch (JSONException e) {

                                                    }
                                                }

                                                @Override
                                                public void onFail() {

                                                }
                                            });                                        }
                                    });
                            Bundle parameters = new Bundle();
                            parameters.putString("fields", "email,gender");
                            request.setParameters(parameters);
                            request.executeAsync();




                        }
                    }
                };
                mProfileTracker.startTracking();
                // App code

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    private boolean facebookPost() {
        //check login
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken == null) {
            Toast.makeText(getApplicationContext(),"Logged out",Toast.LENGTH_SHORT).show();
            return  false;
        } else {
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
