package com.example.barcodeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


import org.w3c.dom.Document;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView format;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.scan_but);
        format = findViewById(R.id.format);
        content = findViewById(R.id.content);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doScan(v);
            }
        });

//        button.setOnClickListener(mScan);
//
//
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
//        integrator.setPrompt("Scan a barcode");
//        integrator.setCameraId(0);  // Use a specific camera of the device
//        integrator.setBeepEnabled(false);
////        integrator.setBarcodeImageEnabled(true);
//        integrator.initiateScan();


    }

    public void doScan(View v) {
        (new IntentIntegrator(this)).initiateScan();
    }

    public void onActivityResult(int request, int result, Intent i) {
        IntentResult scan=IntentIntegrator.parseActivityResult(request,
                result,
                i);

        if (scan!=null) {
            format.setText(scan.getFormatName());
            content.setText(scan.getContents());
        }
    }

//    public Button.OnClickListener mScan = new Button.OnClickListener() {
//        public void onClick(View v) {
//            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
//            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//            startActivityForResult(intent, 0);
//        }
//    };
//
//    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        final TextView textView = findViewById(R.id.scanned_text);
//        if (requestCode == 0) {
//            if (resultCode == RESULT_OK) {
//                String contents = intent.getStringExtra("SCAN_RESULT");
//                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
//                textView.setText("Hello");
//            } else if (resultCode == RESULT_CANCELED) {
//                textView.setText("By");
//            }
//        }
//    }
}
