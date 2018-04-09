package com.anshu.its;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Welcome extends AppCompatActivity {

    private EditText e_Name, e_lastName, e_Company;
    private EditText phoneNumber, eMail, e_Address;
    private Button e_Save, Close;
    private Spinner spinner1;
    private Spinner spinner2;
    private TextView  Name,lastName,Company,eMail1,Address, phoneNumber1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        e_Name = (EditText) findViewById(R.id.firstName);
        e_lastName = (EditText) findViewById(R.id.lastName);
        e_Company = (EditText) findViewById(R.id.et_Organization);
        eMail = (EditText) findViewById(R.id.et_Mail);
        e_Address = (EditText) findViewById(R.id.Address);
        phoneNumber = (EditText) findViewById(R.id.etNumber);
        e_Save = (Button) findViewById(R.id.btnSave);
        spinner1 = (Spinner) findViewById(R.id.etSpinner1);
        spinner2 = (Spinner) findViewById(R.id.etSpinner2);

        List<String> list = new ArrayList<String>();
        list.add("Mr.");
        list.add("Mrs");
        list.add("Miss");

        List<String> list1 = new ArrayList<String>();
        list1.add("MOBILE");
        list1.add("WORK");
        list1.add("HOME");
        list1.add("OFFICE");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list1);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);

        e_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Welcome.this);
//                View mView=getLayoutInflater().inflate(R.layout.layout_dialog,null);
                Name = (TextView) findViewById(R.id.firstName);
                lastName = (TextView) findViewById(R.id.lastName);
                Company = (TextView) findViewById(R.id.et_Organization);
                eMail1 = (TextView) findViewById(R.id.et_Mail);
                Address = (TextView) findViewById(R.id.Address);
                phoneNumber1 = (TextView) findViewById(R.id.etNumber);
                Close = (Button) findViewById(R.id.btnSave);

              //  alert.setView(mView);
                AlertDialog dialog = alert.create();
                dialog.show();
               String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";
                String email = eMail.getText().toString();

                Matcher matcher = Pattern.compile(validemail).matcher(email);
                if (matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                  /*  alert.setTitle("test");
                    alert.setMessage( " Name  " + e_Name.getText().toString() + "\n" + " LastName   " + e_lastName.getText().toString() + "\n" +
                            " Organisation  "+ e_Company.getText().toString()+ "\n"+ " Mobile   " + phoneNumber.getText().toString() +"\n" +
                                   "Email  " + eMail.getText().toString() +"\n" + " Address   " + e_Address.getText().toString());

                    alert.show();
*/
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Email-Id", Toast.LENGTH_LONG).show();
                }
            }

        });

    }


}
