package com.shiviishiv7.helloenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.translate.AmazonTranslateAsyncClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

import java.util.HashMap;
import java.util.Map;

public class WordMeaning extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String editText = "";
    TextView textView;
    EditText text;
    static Map<String,?>map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_meaning);
         pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
         text = findViewById(R.id.editTextTextPersonName);
         textView = findViewById(R.id.textView);
    //test("",editor);
    }
    public void button7(View view){
        editText = text.getText().toString();
        // Toast.makeText(view.getContext(),"text size"+editText,Toast.LENGTH_SHORT).show();
        if(editText.length()>0){
            String string = pref.getString(editText, "");
            if(string.length()>0){
                textView.setText(string);
            }else {
                textView.setText("wait we are finding");
                test(editText,editor);

            //    textView.setText(pref.getString(editText,"Not found"));
            }
        }else {
            Log.d(LOG_TAG, "button7: size less 0");
        }
    }
    private void test(String test, SharedPreferences.Editor editor) {
        Log.d(LOG_TAG, "test: "+test);
        AWSCredentials awsCredentials = new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return "AKIAV372EAOSRQOOSHCK";
            }

            @Override
            public String getAWSSecretKey() {
                return "pj5WPogMu22ciC0My3L/AMEh5VFbUWcCa9tsiQoQ";
            }
        };

        AmazonTranslateAsyncClient translateAsyncClient = new AmazonTranslateAsyncClient(awsCredentials);
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .withText(test)
                .withSourceLanguageCode("en")
                .withTargetLanguageCode("hi");
        translateAsyncClient.translateTextAsync(translateTextRequest, new AsyncHandler<TranslateTextRequest, TranslateTextResult>() {
            @Override
            public void onError(Exception e) {
                Log.e(LOG_TAG, "Error occurred in translating the text: " + e.getLocalizedMessage());
            }

            @Override
            public void onSuccess(TranslateTextRequest request, TranslateTextResult translateTextResult) {
                Log.d(LOG_TAG, "Original Text: " + request.getText());
                Log.d(LOG_TAG, "Translated Text: " + translateTextResult.getTranslatedText());
                editor.putString(request.getText(), translateTextResult.getTranslatedText());
                editor.apply();
                onSuccessFunction();
            }
        });
    }

    private void onSuccessFunction() {
        //Toast.makeText(view.getContext(),"text size"+editText,Toast.LENGTH_SHORT).show();
        if(editText.length()>0){
            String string = pref.getString(editText, "");
            if(string.length()>0){
                textView.setText(string);
            }else {
                textView.setText("wait we are finding");
         //       test(editText,editor);

                textView.setText(pref.getString(editText,"Not found"));
            }
        }else {
            Log.d(LOG_TAG, "button7: size less 0");
        }
    }
    public void button8(View view){
        map = pref.getAll();
//        for (String str:map.keySet()){
//            Log.d(LOG_TAG, "button8: "+str+"\t"+map.get(str));
//        }
        startActivity(new Intent(getApplicationContext(),WordMeanViewData.class));
    }
}
