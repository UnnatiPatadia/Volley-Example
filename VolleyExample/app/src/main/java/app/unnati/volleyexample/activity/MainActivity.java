package app.unnati.volleyexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.unnati.volleyexample.R;
import app.unnati.volleyexample.utils.Constant;

public class MainActivity extends AppCompatActivity {

    TextInputEditText ed_Email,ed_Password;
    String strEmail,strPassword;
    Button btnLogin;
    int mStatusCode;
    String token;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Email = findViewById(R.id.ed_Email);
        ed_Password = findViewById(R.id.ed_Password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail = ed_Email.getText().toString();
                strPassword = ed_Password.getText().toString();

                if (strEmail.isEmpty()) {
                    ed_Email.requestFocus();
                    ed_Email.setError("Enter Email");
                } else if(strPassword.isEmpty()) {
                    ed_Password.requestFocus();
                    ed_Password.setError("Enter Password");
                } else {
                    callLoginService();
                }
            }
        });
    }

    private void callLoginService() {
        pDialog = ProgressDialog.show( MainActivity.this ,"" ,"Wait..." ,false ,false );
        StringRequest postRequest = new StringRequest( Request.Method.POST , Constant.POST_URL ,
                new Response.Listener <String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d( "Unnati " ,"Response : " + response );
                        pDialog.dismiss();
                        if (mStatusCode == 200) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                token = jsonObject.getString("token");
                                startActivity(new Intent(MainActivity.this, HomeScreen.class));
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        pDialog.dismiss();
                        Log.d( "Error.Response" ,String.valueOf( error ) );
                        Toast.makeText(MainActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map <String, String> params = new HashMap<String, String>();
                params.put("email",strEmail); // eve.holt@reqres.in
                params.put("password",strPassword); // pistol
                return params;
            }
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( getApplicationContext() );
        requestQueue.add( postRequest );
    }
}
