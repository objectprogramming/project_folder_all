package com.example.albicilla.quiz;

import com.example.albicilla.quiz.Question;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    //リクエストコード
    private static final int MYREQUEST=1;
    //現在の問題と回答
    public String question;
    public String answer;

    //全ての問題と回答を管理するArrayList
    public ArrayList<Question> questions = new ArrayList<Question>();

    //「クイズ」ボタンのイベントリスナー
    public class QuizBtnOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //問題の回答を取得
            Random random = new Random();
            //
            int randomNum = random.nextInt(questions.size());
            //問題と答えのペアをランダムに取り出す
            Question aQuestion = questions.get(randomNum);
            //問題
            question = questions.get(randomNum).getQuestion();
            //答え
            answer = questions.get(randomNum).getAnswer();

            //インテントを生成
            Intent intent = new Intent(MainActivity.this , ShowQuizActivity.class);

            //付加情報として問題を設定
            intent.putExtra("QUESTION",question);

            //アクティビティを起動
            startActivityForResult(intent,MYREQUEST);

        }
    }

    //サブアクティビティの戻り値を処理
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == MYREQUEST){
            if(resultCode == Activity.RESULT_OK){
                Bundle extras = data.getExtras();
                String userAnswer = extras.getString("ANSWER").trim();
                if(userAnswer.equals(answer)){
                    Toast.makeText(MainActivity.this, "正解です", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "誤りです", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //クイズの生成
        questions.add(new Question("神奈川県","横浜"));
        questions.add(new Question("東京都","東京"));
        questions.add(new Question("千葉県","千葉"));
        questions.add(new Question("奈良県","奈良"));
        questions.add(new Question("石川県","金沢"));
        questions.add(new Question("滋賀県","大津"));
        questions.add(new Question("茨城県","水戸"));
        questions.add(new Question("愛知県","名古屋"));

        //「クイズ」ボタンのイベントリスナーの設定
        Button quizBtn = (Button) findViewById(R.id.quizButton);
        quizBtn.setOnClickListener(new QuizBtnOnClickListener());




    }
}
