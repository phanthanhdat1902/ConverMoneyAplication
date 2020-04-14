package com.example.convermoneyaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean flag;
    List<MoneyClass> listMoney;
    Spinner spinner_first;
    Spinner spinner_second;
    TextView moneyFirst;
    TextView moneySecond;
    String stringOne="";
    String stringTwo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag=false;
        moneyFirst=findViewById(R.id.moneyFirst);
        moneySecond=findViewById(R.id.moneySecond);
        moneyFirst.setTypeface(null,Typeface.BOLD_ITALIC);
        listMoney=new ArrayList<MoneyClass>();
        listMoney.add(new MoneyClass("VietNam - Dong","Dong",23435 ));
        listMoney.add(new MoneyClass("United Kingdom - Pound","£",(float)0.80 ));
        listMoney.add(new MoneyClass("Europe - Euro","€",(float)0.91 ));
        listMoney.add(new MoneyClass("Japan - Yen","¥",(float)108.46 ));
        listMoney.add(new MoneyClass("Korea - WON","₩ ",(float)1211.05 ));
        listMoney.add(new MoneyClass("United States - USD","$",(float)1 ));
        moneyFirst.setOnClickListener(this);
        moneySecond.setOnClickListener(this);
        findViewById(R.id.buttonC).setOnClickListener(this);
        findViewById(R.id.buttonCE).setOnClickListener(this);
        findViewById(R.id.buttonOne).setOnClickListener(this);
        findViewById(R.id.buttonTwo).setOnClickListener(this);
        findViewById(R.id.buttonThree).setOnClickListener(this);
        findViewById(R.id.buttonFour).setOnClickListener(this);
        findViewById(R.id.buttonFive).setOnClickListener(this);
        findViewById(R.id.buttonSix).setOnClickListener(this);
        findViewById(R.id.buttonSeven).setOnClickListener(this);
        findViewById(R.id.buttonEight).setOnClickListener(this);
        findViewById(R.id.buttonNine).setOnClickListener(this);
        findViewById(R.id.buttonDoc).setOnClickListener(this);
        findViewById(R.id.buttonZero).setOnClickListener(this);
        MoneyAdapter moneyAdapter=new MoneyAdapter(listMoney);
        spinner_first=findViewById(R.id.spinnerFirst);
        spinner_first.setAdapter(moneyAdapter);
        spinner_second=findViewById(R.id.spinnerSecond);
        spinner_second.setAdapter(moneyAdapter);
        spinner_first.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stringOne="";
                stringTwo="";
                NumberFormat currentLocale = NumberFormat.getInstance();
                MoneyClass money1=listMoney.get(spinner_first.getSelectedItemPosition());
                MoneyClass money2=listMoney.get(spinner_second.getSelectedItemPosition());
                TextView icon= findViewById(R.id.icon_moneyFirst);
                icon.setText(listMoney.get(position).getLogo());
                String informationMoneyString=new String();
                float check=money2.getCoverUSD()/money1.getCoverUSD();
                if(check<=1){
                    informationMoneyString="1 "+ money2.getName()+" = "+currentLocale.format(money1.getCoverUSD()/money2.getCoverUSD())+" "+money1.getName();
                }else{
                    informationMoneyString="1 "+ money1.getName()+" = "+currentLocale.format(check)+" "+money2.getName();
                }
                TextView informationMoney=findViewById(R.id.informationMoney);
                informationMoney.setText(informationMoneyString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stringOne="";
                stringTwo="";
                NumberFormat currentLocale = NumberFormat.getInstance();
                MoneyClass money1=listMoney.get(spinner_first.getSelectedItemPosition());
                MoneyClass money2=listMoney.get(spinner_second.getSelectedItemPosition());
                TextView icon= findViewById(R.id.icon_moneySecond);
                icon.setText(money2.getLogo());
                String informationMoneyString=new String();
                float check=money2.getCoverUSD()/money1.getCoverUSD();
                if(check<=1){
                    informationMoneyString="1 "+ money2.getName()+" = "+currentLocale.format(money1.getCoverUSD()/money2.getCoverUSD())+" "+money1.getName();
                }else{
                    informationMoneyString="1 "+ money1.getName()+" = "+currentLocale.format(check)+" "+money2.getName();
                }
                TextView informationMoney=findViewById(R.id.informationMoney);
                informationMoney.setText(informationMoneyString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        NumberFormat currentLocale = NumberFormat.getInstance();
        int id=v.getId();
        MoneyClass money1=listMoney.get(spinner_first.getSelectedItemPosition());
        MoneyClass money2=listMoney.get(spinner_second.getSelectedItemPosition());
        float one;
        float kq;
        String stringKQ;
        if (id==R.id.buttonOne){
            if(!flag){
                stringTwo="";
                stringOne+="1";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="1";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonTwo){
            if(!flag){
                stringTwo="";
                stringOne+="2";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="2";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonThree){
            if(!flag){
                stringTwo="";
                stringOne+="3";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="3";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonFour){
            if(!flag){
                stringTwo="";
                stringOne+="4";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="4";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonFive){
            if(!flag){
                stringTwo="";
                stringOne+="5";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="5";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonSix){
            if(!flag){
                stringTwo="";
                stringOne+="6";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));;
            }else{
                stringOne="";
                stringTwo+="6";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonSeven){
            if(!flag){
                stringTwo="";
                stringOne+="7";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="7";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));;
            }
        }else  if (id==R.id.buttonEight){
            if(!flag){
                stringTwo="";
                stringOne+="8";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="8";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonNine){
            if(!flag){
                stringTwo="";
                stringOne+="9";
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                one=Float.parseFloat(stringOne);
                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }else{
                stringOne="";
                stringTwo+="9";
                moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                one=Float.parseFloat(stringTwo);
                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                stringKQ=String.format("%.02f",kq);
                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else  if (id==R.id.buttonZero){
            if(!flag){
                if(!stringOne.isEmpty()){
                    stringTwo="";
                    stringOne+="0";
                    moneyFirst.setText(currentLocale.format(Float.parseFloat(stringOne)));
                    one=Float.parseFloat(stringOne);
                    kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                    stringKQ=String.format("%.02f",kq);
                    moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));
                }
            }else{
                if(!stringTwo.isEmpty()){
                    stringOne="";
                    stringTwo+="0";
                    moneySecond.setText(currentLocale.format(Float.parseFloat(stringTwo)));
                    one=Float.parseFloat(stringTwo);
                    kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
                    stringKQ=String.format("%.02f",kq);
                    moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
                }
            }
        }else  if (id==R.id.buttonDoc){
            if(!flag){
//                stringTwo="";
//                stringOne+="1";
//                moneyFirst.setText(stringOne);
//                one=Float.parseFloat(stringOne);
//                kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
//                moneySecond.setText(String.format("%.02f",Float.parseFloat( currentLocale.format(kq))));
            }else{
//                stringOne="";
//                stringTwo+="1";
//                moneySecond.setText(stringTwo);
//                one=Float.parseFloat(stringTwo);
//                kq=one*(money1.getCoverUSD()/money2.getCoverUSD());
//                stringKQ=String.format("%.02f",kq);
//                moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
            }
        }else if(id==R.id.moneyFirst){
            flag=false;
            moneyFirst.setTypeface(null,Typeface.BOLD_ITALIC);
            moneySecond.setTypeface(null,Typeface.NORMAL);
            stringOne="";
            stringTwo="";
        }else if(id==R.id.moneySecond){
            stringOne="";
            stringTwo="";
            flag=true;
            moneySecond.setTypeface(null,Typeface.BOLD_ITALIC);
            moneyFirst.setTypeface(null,Typeface.NORMAL);
        }else if(id==R.id.buttonCE){
            stringOne="";
            stringTwo="";
            moneyFirst.setText("0");
            moneySecond.setText("0");
        }else if(id==R.id.buttonC){
            if(!flag){
                if(!stringOne.isEmpty()){
                    //cat chuoi
                    stringOne=stringOne.substring(0, stringOne.length()-1) + stringOne.substring(stringOne.length()-1 + 1);
                    if(!stringOne.isEmpty()){
                        one=Float.parseFloat(stringOne);
                        kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                        moneyFirst.setText(stringOne);
                        stringKQ=String.format("%.02f",kq);
                        moneySecond.setText(currentLocale.format(Float.parseFloat(stringKQ)));

                    }else{
                        stringTwo="";
                        moneySecond.setText("0");
                        moneyFirst.setText("0");
                    }
                }
            }else{
                if(!stringTwo.isEmpty()){
                    stringTwo=stringTwo.substring(0, stringTwo.length()-1) + stringTwo.substring(stringTwo.length()-1 + 1);
                    if(!stringTwo.isEmpty()){
                        one=Float.parseFloat(stringOne);
                        kq=one*(money2.getCoverUSD()/money1.getCoverUSD());
                        moneySecond.setText(stringTwo);
                        stringKQ=String.format("%.02f",kq);
                        moneyFirst.setText(currentLocale.format(Float.parseFloat(stringKQ)));
                    }else{
                        stringOne="";
                        moneySecond.setText("0");
                        moneyFirst.setText("0");
                    }
                }
            }
        }
    }
}
