package com.example.albicilla.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by albicilla on 2016/11/22.
 */

public class ShowQuizActivity extends Activity {
    //インテント
    Intent intent;

    //「OK」ボタンのイベントリスナー
    public class answerBtnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            EditText answerText = (EditText) findViewById(R.id.answerText);
            String answer = answerText.getText().toString();
            //答えを戻す
            intent.putExtra("ANSWER",answer);
            //リザルトコードを設定
            setResult(Activity.RESULT_OK,intent);

            //前のアクティビティに戻る
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showquiz);

        //インテントを取得
        intent = getIntent();

        //Bundleオブジェクトを取り出す
        Bundle extras = intent.getExtras();
        String question = null;
        //Bundleから問題を取り出す
        if(extras != null){
            question = extras.getString("QUESTION");
        }

        //テキストビューに問題を表示
        TextView questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(question + "の県庁所在地は?");

        //「OK」ボタンをクリックしたらアクティビティを閉じる
        Button answerBtn = (Button) findViewById(R.id.answerBtn);
        answerBtn.setOnClickListener(new answerBtnOnClickListener());
    }

}
