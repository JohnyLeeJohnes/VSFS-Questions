package com.example.vsfsotazky;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.vsfsotazky.databinding.ActivityMainBinding;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> answeredQuestions;
    private ArrayList<Question> todoQuestions;
    private Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Init
        final String[] items = new String[]{
                getString(R.string.field_is),
                getString(R.string.field_swi),
                getString(R.string.field_ti)
        };
        Spinner dropdown = findViewById(R.id.dropdown_field);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        answeredQuestions = new ArrayList<>();

        //Actions
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("DropDownSelection", "" + position);
                switch (position) {
                    case 0:
                        todoQuestions = getQuestionsIS();
                        break;
                    case 1:
                        todoQuestions = getQuestionsSWI();
                        break;
                    case 2:
                        todoQuestions = getQuestionsTI();
                    default:
                        break;
                }

                resetScreen();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.v("DropDownSelection", "Error");
            }
        });

        Button button = findViewById(R.id.generate_question);
        button.setOnClickListener(v -> {
            TextView question = findViewById(R.id.question);
            TextView questionDesc = findViewById(R.id.question_description);
            TextView questionDone = findViewById(R.id.question_done);
            Question q = nextQuestion();
            if (q != null) {
                question.setText(q.getName());
                questionDesc.setText(q.getDescription());
                questionDone.setText(answeredQuestions.toString());
            } else {
                question.setText("Everythings is done!");
                questionDesc.setText("");
            }
        });
    }

    private void resetScreen() {
        answeredQuestions.clear();

        TextView question = findViewById(R.id.question);
        TextView questionDesc = findViewById(R.id.question_description);
        TextView questionDone = findViewById(R.id.question_done);

        question.setText("");
        questionDesc.setText("");
        questionDone.setText("");
    }

    public Question nextQuestion() {
        if (todoQuestions.size() > 0) {
            int index = r.nextInt(todoQuestions.size());
            Question q = todoQuestions.get(index);
            todoQuestions.remove(index);
            answeredQuestions.add(q.getId());
            return q;
        }
        return null;
    }

    public ArrayList<Question> getQuestionsIS() {
        ArrayList<Question> questionsIS = new ArrayList<>();
        questionsIS.add(new Question(1, getString(R.string.QIS1), getString(R.string.QIS1S)));
        questionsIS.add(new Question(2, getString(R.string.QIS2), getString(R.string.QIS2S)));
        questionsIS.add(new Question(3, getString(R.string.QIS3), getString(R.string.QIS3S)));
        questionsIS.add(new Question(4, getString(R.string.QIS4), getString(R.string.QIS4S)));
        questionsIS.add(new Question(5, getString(R.string.QIS5), getString(R.string.QIS5S)));
        questionsIS.add(new Question(6, getString(R.string.QIS6), getString(R.string.QIS6S)));
        questionsIS.add(new Question(7, getString(R.string.QIS7), getString(R.string.QIS7S)));
        questionsIS.add(new Question(8, getString(R.string.QIS8), getString(R.string.QIS8S)));
        questionsIS.add(new Question(9, getString(R.string.QIS9), getString(R.string.QIS9S)));
        questionsIS.add(new Question(10, getString(R.string.QIS10), getString(R.string.QIS10S)));
        questionsIS.add(new Question(11, getString(R.string.QIS11), getString(R.string.QIS11S)));
        questionsIS.add(new Question(12, getString(R.string.QIS12), getString(R.string.QIS12S)));
        questionsIS.add(new Question(13, getString(R.string.QIS13), getString(R.string.QIS13S)));
        questionsIS.add(new Question(14, getString(R.string.QIS14), getString(R.string.QIS14S)));
        questionsIS.add(new Question(15, getString(R.string.QIS15), getString(R.string.QIS15S)));
        questionsIS.add(new Question(16, getString(R.string.QIS16), getString(R.string.QIS16S)));
        questionsIS.add(new Question(17, getString(R.string.QIS17), getString(R.string.QIS17S)));
        questionsIS.add(new Question(18, getString(R.string.QIS18), getString(R.string.QIS18S)));
        questionsIS.add(new Question(19, getString(R.string.QIS19), getString(R.string.QIS19S)));
        questionsIS.add(new Question(20, getString(R.string.QIS20), getString(R.string.QIS20S)));
        questionsIS.add(new Question(21, getString(R.string.QIS21), getString(R.string.QIS21S)));
        questionsIS.add(new Question(22, getString(R.string.QIS22), getString(R.string.QIS22S)));
        questionsIS.add(new Question(23, getString(R.string.QIS23), getString(R.string.QIS23S)));
        questionsIS.add(new Question(24, getString(R.string.QIS24), getString(R.string.QIS24S)));
        questionsIS.add(new Question(25, getString(R.string.QIS25), getString(R.string.QIS25S)));
        questionsIS.add(new Question(26, getString(R.string.QIS26), getString(R.string.QIS26S)));
        questionsIS.add(new Question(27, getString(R.string.QIS27), getString(R.string.QIS27S)));
        questionsIS.add(new Question(28, getString(R.string.QIS28), getString(R.string.QIS28S)));
        questionsIS.add(new Question(29, getString(R.string.QIS29), getString(R.string.QIS29S)));
        questionsIS.add(new Question(30, getString(R.string.QIS30), getString(R.string.QIS30S)));
        return questionsIS;
    }

    public ArrayList<Question> getQuestionsSWI() {
        ArrayList<Question> questionsSWI = new ArrayList<>();
        questionsSWI.add(new Question(1, getString(R.string.QSWI1), getString(R.string.QSWI1S)));
        questionsSWI.add(new Question(2, getString(R.string.QSWI2), getString(R.string.QSWI2S)));
        questionsSWI.add(new Question(3, getString(R.string.QSWI3), getString(R.string.QSWI3S)));
        questionsSWI.add(new Question(4, getString(R.string.QSWI4), getString(R.string.QSWI4S)));
        questionsSWI.add(new Question(5, getString(R.string.QSWI5), getString(R.string.QSWI5S)));
        questionsSWI.add(new Question(6, getString(R.string.QSWI6), getString(R.string.QSWI6S)));
        questionsSWI.add(new Question(7, getString(R.string.QSWI7), getString(R.string.QSWI7S)));
        questionsSWI.add(new Question(8, getString(R.string.QSWI8), getString(R.string.QSWI8S)));
        questionsSWI.add(new Question(9, getString(R.string.QSWI9), getString(R.string.QSWI9S)));
        questionsSWI.add(new Question(10, getString(R.string.QSWI10), getString(R.string.QSWI10S)));
        questionsSWI.add(new Question(11, getString(R.string.QSWI11), getString(R.string.QSWI11S)));
        questionsSWI.add(new Question(12, getString(R.string.QSWI12), getString(R.string.QSWI12S)));
        questionsSWI.add(new Question(13, getString(R.string.QSWI13), getString(R.string.QSWI13S)));
        questionsSWI.add(new Question(14, getString(R.string.QSWI14), getString(R.string.QSWI14S)));
        questionsSWI.add(new Question(15, getString(R.string.QSWI15), getString(R.string.QSWI15S)));
        questionsSWI.add(new Question(16, getString(R.string.QSWI16), getString(R.string.QSWI16S)));
        questionsSWI.add(new Question(17, getString(R.string.QSWI17), getString(R.string.QSWI17S)));
        questionsSWI.add(new Question(18, getString(R.string.QSWI18), getString(R.string.QSWI18S)));
        questionsSWI.add(new Question(19, getString(R.string.QSWI19), getString(R.string.QSWI19S)));
        questionsSWI.add(new Question(20, getString(R.string.QSWI20), getString(R.string.QSWI20S)));
        questionsSWI.add(new Question(21, getString(R.string.QSWI21), getString(R.string.QSWI21S)));
        questionsSWI.add(new Question(22, getString(R.string.QSWI22), getString(R.string.QSWI22S)));
        questionsSWI.add(new Question(23, getString(R.string.QSWI23), getString(R.string.QSWI23S)));
        questionsSWI.add(new Question(24, getString(R.string.QSWI24), getString(R.string.QSWI24S)));
        questionsSWI.add(new Question(25, getString(R.string.QSWI25), getString(R.string.QSWI25S)));
        questionsSWI.add(new Question(26, getString(R.string.QSWI26), getString(R.string.QSWI26S)));
        questionsSWI.add(new Question(27, getString(R.string.QSWI27), getString(R.string.QSWI27S)));
        questionsSWI.add(new Question(28, getString(R.string.QSWI28), getString(R.string.QSWI28S)));
        questionsSWI.add(new Question(29, getString(R.string.QSWI29), getString(R.string.QSWI29S)));
        questionsSWI.add(new Question(30, getString(R.string.QSWI30), getString(R.string.QSWI30S)));
        return questionsSWI;
    }

    public ArrayList<Question> getQuestionsTI() {
        ArrayList<Question> questionsTI = new ArrayList<>();
        questionsTI.add(new Question(1, getString(R.string.QTI1), getString(R.string.QTI1S)));
        questionsTI.add(new Question(2, getString(R.string.QTI2), getString(R.string.QTI2S)));
        questionsTI.add(new Question(3, getString(R.string.QTI3), getString(R.string.QTI3S)));
        questionsTI.add(new Question(4, getString(R.string.QTI4), getString(R.string.QTI4S)));
        questionsTI.add(new Question(5, getString(R.string.QTI5), getString(R.string.QTI5S)));
        questionsTI.add(new Question(6, getString(R.string.QTI6), getString(R.string.QTI6S)));
        questionsTI.add(new Question(7, getString(R.string.QTI7), getString(R.string.QTI7S)));
        questionsTI.add(new Question(8, getString(R.string.QTI8), getString(R.string.QTI8S)));
        questionsTI.add(new Question(9, getString(R.string.QTI9), getString(R.string.QTI9S)));
        questionsTI.add(new Question(10, getString(R.string.QTI10), getString(R.string.QTI10S)));
        questionsTI.add(new Question(11, getString(R.string.QTI11), getString(R.string.QTI11S)));
        questionsTI.add(new Question(12, getString(R.string.QTI12), getString(R.string.QTI12S)));
        questionsTI.add(new Question(13, getString(R.string.QTI13), getString(R.string.QTI13S)));
        questionsTI.add(new Question(14, getString(R.string.QTI14), getString(R.string.QTI14S)));
        questionsTI.add(new Question(15, getString(R.string.QTI15), getString(R.string.QTI15S)));
        questionsTI.add(new Question(16, getString(R.string.QTI16), getString(R.string.QTI16S)));
        questionsTI.add(new Question(17, getString(R.string.QTI17), getString(R.string.QTI17S)));
        questionsTI.add(new Question(18, getString(R.string.QTI18), getString(R.string.QTI18S)));
        questionsTI.add(new Question(19, getString(R.string.QTI19), getString(R.string.QTI19S)));
        questionsTI.add(new Question(20, getString(R.string.QTI20), getString(R.string.QTI20S)));
        questionsTI.add(new Question(21, getString(R.string.QTI21), getString(R.string.QTI21S)));
        questionsTI.add(new Question(22, getString(R.string.QTI22), getString(R.string.QTI22S)));
        questionsTI.add(new Question(23, getString(R.string.QTI23), getString(R.string.QTI23S)));
        questionsTI.add(new Question(24, getString(R.string.QTI24), getString(R.string.QTI24S)));
        questionsTI.add(new Question(25, getString(R.string.QTI25), getString(R.string.QTI25S)));
        questionsTI.add(new Question(26, getString(R.string.QTI26), getString(R.string.QTI26S)));
        questionsTI.add(new Question(27, getString(R.string.QTI27), getString(R.string.QTI27S)));
        questionsTI.add(new Question(28, getString(R.string.QTI28), getString(R.string.QTI28S)));
        questionsTI.add(new Question(29, getString(R.string.QTI29), getString(R.string.QTI29S)));
        questionsTI.add(new Question(30, getString(R.string.QTI30), getString(R.string.QTI30S)));
        return questionsTI;
    }

}