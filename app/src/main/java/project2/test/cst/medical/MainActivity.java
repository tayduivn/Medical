package project2.test.cst.medical;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    EditText id;
    EditText name;
    EditText father;
    EditText age;
    EditText stage;
    EditText evidence;
    EditText marks;
    EditText sign;
    EditText exname;
    EditText exsign;
    EditText designation;
    EditText regis;
    TextView submit;
    Mainbean mainbean = null;


    public static final String mypreference = "mypref";
    public static final String buSurveyerId = "buSurveyerIdKey";
    SharedPreferences sharedpreferences;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        sharedpreferences = this.getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);



        name=(EditText)findViewById(R.id.name);
        father=(EditText)findViewById(R.id.father);
        age=(EditText)findViewById(R.id.age);
        stage=(EditText)findViewById(R.id.stage);
        evidence=(EditText)findViewById(R.id.evidence);
        marks=(EditText)findViewById(R.id.marks);
        sign=(EditText)findViewById(R.id.sign);
        exname=(EditText)findViewById(R.id.exname);
        exsign=(EditText)findViewById(R.id.exsign);
        designation=(EditText)findViewById(R.id.designation);
        regis=(EditText)findViewById(R.id.regis);
        submit=(TextView)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mainbean tempmainbean=new Mainbean
                        (name.getText().toString(),
                        father.getText().toString(),
                        age.getText().toString(),
                        stage.getText().toString(),
                        evidence.getText().toString(),
                        marks.getText().toString(),
                        sign.getText().toString(),
                        exname.getText().toString(),
                        exsign.getText().toString(),
                        designation.getText().toString(),
                        regis.getText().toString());
                String jsonVal=new Gson().toJson(tempmainbean);
                Log.e("xxxxxxxxxxxxx", jsonVal);

                if (mainbean == null) {
                    tempmainbean.setId(String.valueOf(System.currentTimeMillis()));
                } else {
                    tempmainbean.setId(mainbean.id);
                }

                getCreateTest(tempmainbean.id,  sharedpreferences.getString(buSurveyerId, ""), jsonVal);

            }
        });

        try {
            mainbean = (Mainbean) getIntent().getSerializableExtra("object");
            if (mainbean != null) {
                name.setText(mainbean.name);
                father.setText(mainbean.father);
                age.setText(mainbean.age);
                stage.setText(mainbean.stage);
                evidence.setText(mainbean.evidence);
                marks.setText(mainbean.marks);
                sign.setText(mainbean.sign);
                exname.setText(mainbean.exname);
                exsign.setText(mainbean.exsign);
                designation.setText(mainbean.designation);
                regis.setText(mainbean.regis);


            }
        }catch (Exception e) {
            Log.e("xxxxxx", "Something went wrong");
        }
        }
    private void getCreateTest(final String mId, final String surveyer, final String data) {
        this.pDialog.setMessage("Creating...");
        showDialog();
        StringRequest local16 = new StringRequest(1, "http://climatesmartcity.com/UBA/Medical.php", new Response.Listener<String>() {
            public void onResponse(String paramString) {
                Log.d("tag", "Register Response: " + paramString.toString());
                hideDialog();
                try {
                    JSONObject localJSONObject1 = new JSONObject(paramString);
                    String str = localJSONObject1.getString("message");
                    if (localJSONObject1.getInt("success") == 1) {
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    return;
                } catch (JSONException localJSONException) {
                    localJSONException.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError paramVolleyError) {
                Log.e("tag", "Fetch Error: " + paramVolleyError.getMessage());
                Toast.makeText(getApplicationContext(), paramVolleyError.getMessage(), Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        }) {
            protected Map<String, String> getParams() {
                HashMap<String, String> localHashMap = new HashMap<String, String>();
                if (mId != null) {
                    localHashMap.put("id", mId);
                }
                localHashMap.put("formId", mId);
                localHashMap.put("surveyer", surveyer);
                localHashMap.put("data", data);


                return localHashMap;
            }
        };
        AppController.getInstance().addToRequestQueue(local16, TAG);
    }


    private void hideDialog() {

        if (this.pDialog.isShowing()) this.pDialog.dismiss();
    }

    private void showDialog() {

        if (!this.pDialog.isShowing()) this.pDialog.show();
    }
}



