package ward.net.cooknettech.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.RippleManager;

import ward.net.cooknettech.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    private ImageView imageViewLoginHeader;
    private ImageView imageViewLoginFooter;
  //  private Button buttonLoginUserPassword;
    private LinearLayout linearLayout;
    private TextView textView;
    private TextView textViewSignUp;
    private EditText emailAddressEditText;
    private EditText passwordEditText;
    private RippleManager  rippleManager;
    private ImageButton facebookLogin;
    private ImageButton googleLogin;
    private ImageButton twitterLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


    }

    private void initViews(){
        imageViewLoginHeader = (ImageView) findViewById(R.id.imageViewLoginHeader);
        imageViewLoginFooter = (ImageView) findViewById(R.id.imageViewLoginFooter);
       // buttonLoginUserPassword = (Button) findViewById(R.id.buttonLoginUserPassword);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView = (TextView) findViewById(R.id.textView);
       facebookLogin= (ImageButton) findViewById(R.id.buttonLoginFacebook);
      googleLogin= (ImageButton) findViewById(R.id.buttonLoginGoogle);
       twitterLogin= (ImageButton) findViewById(R.id.buttonLoginTwitter);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);
        facebookLogin.setOnClickListener(this);
        googleLogin.setOnClickListener(this);
        twitterLogin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
        emailAddressEditText=getEditTextLoginEmail();
        passwordEditText=getEditTextLoginPassword();
    }

    private EditText getEditTextLoginEmail(){
        return (EditText) findViewById(R.id.editTextLoginEmail);
    }

    private EditText getEditTextLoginPassword(){
        return (EditText) findViewById(R.id.editTextLoginPassword);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLoginFacebook:
                //TODO implement
                break;
            case R.id.buttonLoginGoogle:
                //TODO implement
                break;
            case R.id.buttonLoginTwitter:
                //TODO implement
                break;
            case R.id.textViewSignUp:
                break;
        }
    }
}
