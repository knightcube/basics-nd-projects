package samples.knightcube.com.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA;
    int scoreB;
    int wicketsA;
    int wicketsB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void oneRunToA(View view){
        scoreA++;
        display();
    }
    public void oneRunDecreaseFromA(View view){
        scoreA--;
        display();
    }
    public void oneRunToB(View view){
        scoreB++;
        display();
    }
    public void oneRunDecreaseFromB(View view){
        scoreB--;
        display();
    }
    public void fourRunsToA(View view){
        scoreA+=4;
        display();
    }
    public void fourRunsToB(View view) {
        scoreB += 4;
        display();
    }
    public void sixRunsToA(View view){
        scoreA+=6;
        display();
    }
    public void sixRunsToB(View view){
        scoreB+=6;
        display();
    }
    public void outA(View view){
        wicketsA++;
        display();
    }
    public void outB(View view){
        wicketsB++;
        display();
    }
    public void display(){
        TextView scoreAText = (TextView)findViewById(R.id.score_A_text);
        TextView scoreBText = (TextView)findViewById(R.id.score_B_text);
        TextView wicketsAText = (TextView)findViewById(R.id.wickets_A_text);
        TextView wicketsBText = (TextView)findViewById(R.id.wickets_B_text);
        scoreAText.setText(Integer.toString(scoreA));
        scoreBText.setText(Integer.toString(scoreB));
        wicketsAText.setText(Integer.toString(wicketsA));
        wicketsBText.setText(Integer.toString(wicketsB));
    }
    public void resetMatch(View view){
        scoreA=0;
        scoreB=0;
        wicketsA=0;
        wicketsB=0;
        display();
        display();
        display();
        display();
    }
}
