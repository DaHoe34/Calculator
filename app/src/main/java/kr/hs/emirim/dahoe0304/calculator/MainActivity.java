package kr.hs.emirim.dahoe0304.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butPlus, butMinus, butDivide, butMultiply;
    EditText editNum1, editNum2;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butPlus=(Button)findViewById(R.id.but_plus);
        butMinus=(Button)findViewById(R.id.but_minus);
        butDivide=(Button)findViewById(R.id.but_divide);
        butMultiply=(Button)findViewById(R.id.but_multiply);    //참조변수에 대입 OK!
        editNum1=(EditText)findViewById(R.id.edit_num1);
        editNum2=(EditText)findViewById(R.id.edit_num2);
        textResult=(TextView)findViewById(R.id.text_result);
        butPlus.setOnClickListener(this);   //onClick 호출
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultiply.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override   //추상메소드가 구현됨
    public void onClick(View v) {   //어디서 이벤트가 시작되었는지 알수있다.
        //2개의 EditText에 입력된 값을 반환받는다.
        String num1Str=editNum1.getText().toString();  //텍스트를 반환하는 메소드 : getText();
        String num2Str=editNum2.getText().toString();
        int num1=Integer.parseInt(num1Str); //int로 형변환
        int num2=Integer.parseInt(num2Str);
        double result=0;

        switch(v.getId()){  //객체가 가지고 있는 id값
            case R.id.but_plus:
                result=num1+num2;
                break;
            case R.id.but_minus:
                result=num1-num2;
                break;
            case R.id.but_divide:
                result=(double)num1/num2;   //몫만 반환되므로, 형변환을 해야지만 정확한 값이 나옴
                break;
            case R.id.but_multiply:
                result=num1*num2;
                break;
        }
        textResult.setText("* 계산 결과 : "+result);
    }
}
