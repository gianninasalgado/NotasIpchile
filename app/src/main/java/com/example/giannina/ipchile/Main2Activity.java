package com.example.giannina.ipchile;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.giannina.ipchile.R.id.btn_Calcular;
import static com.example.giannina.ipchile.R.id.epe1;
import static com.example.giannina.ipchile.R.id.epr1;
import static com.example.giannina.ipchile.R.id.notaExamen;
import static com.example.giannina.ipchile.R.id.promedio;
import static com.example.giannina.ipchile.R.id.promedioFinal;


public class Main2Activity extends AppCompatActivity {

    Button volver;
    EditText p1, p2, p3, p4, a1, a2, a3, a4;
    Button calcular;
    EditText promedioN;
    EditText necExamen;
    EditText notaExamen;
    EditText promedioFinal;
    Button calculoFinal;

    Double presentacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        p1 = (EditText) findViewById(R.id.epr1);
        p2 = (EditText) findViewById(R.id.epe1);
        p3 = (EditText) findViewById(R.id.epr2);
        p4 = (EditText) findViewById(R.id.epe2);

        a1 = (EditText) findViewById(R.id.eva1);
        a2 = (EditText) findViewById(R.id.eva2);
        a3 = (EditText) findViewById(R.id.eva3);
        a4 = (EditText) findViewById(R.id.eva4);

        promedioN = (EditText) findViewById(R.id.promedio);

        necExamen = (EditText) findViewById(R.id.examen);

        notaExamen = (EditText) findViewById(R.id.notaExamen);

        promedioFinal = (EditText) findViewById(R.id.promedioFinal);

        calcular = (Button) findViewById(R.id.btn_Calcular);

        volver = (Button) findViewById(R.id.btn_volver);

        calculoFinal = (Button) findViewById(R.id.btn_calculoFinal);





        p1.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        p2.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        p3.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        p4.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);

        a1.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        a2.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        a3.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);
        a4.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);

        promedioN.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);

        necExamen.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);

        notaExamen.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);

        promedioFinal.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorDanger), PorterDuff.Mode.SRC_ATOP);



        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (validarVacios(p1, p2, p3, p4, a1, a2, a3, a3, a4)) {
                    //Toast.makeText(Main2Activity.this, epr1, Toast.LENGTH_SHORT).show();//

                    Double epr1 = Double.parseDouble(p1.getText().toString());
                    Double epe1 = Double.parseDouble(p2.getText().toString());
                    Double epr2 = Double.parseDouble(p3.getText().toString());
                    Double epe2 = Double.parseDouble(p4.getText().toString());

                    Double eva1 = Double.parseDouble(a1.getText().toString());
                    Double eva2 = Double.parseDouble(a2.getText().toString());
                    Double eva3 = Double.parseDouble(a3.getText().toString());
                    Double eva4 = Double.parseDouble(a4.getText().toString());

                    Double porcEpr1 = epr1 * 0.10;
                    Double porcEpe1 = epe1 * 0.15;
                    Double porcEpr2 = epr2 * 0.20;
                    Double porcEpe2 = epe2 * 0.25;
                    Double totalEp = (porcEpr1 + porcEpe1 + porcEpr2 + porcEpe2);

                    Double promedioEvas = (eva1 + eva2 + eva3 + eva4) / 4;
                    Double totalEvas = promedioEvas * 0.30;

                    presentacion = redonde(totalEp + totalEvas);
                    String proPresentacion = Double.toString(presentacion);
                    promedioN.setText(proPresentacion);

                    Double nExamen = redondear((3.96 - (presentacion * 0.70)) / 0.30);
                    String neExamen = Double.toString(nExamen);
                    necExamen.setText(neExamen);




                    // Toast.makeText(Main2Activity.this, "Nota Presentación"+Double.toString(presentacion), Toast.LENGTH_SHORT).show();//

                    // promedioN.getText(this+Double.toString(presentacion),Toast.LENGTH_SHORT).SHOW(); //


                    if (epr1 < 4.0) {
                        Toast.makeText(Main2Activity.this, "Nota EPR1 bajo 4.0, debes dar examen", Toast.LENGTH_SHORT).show();

                    } else {

                        if (epe1 < 4.0) {
                            Toast.makeText(Main2Activity.this, "Nota EPE1 bajo 4.0, debes dar examen", Toast.LENGTH_SHORT).show();

                        } else {
                            if (epr2 < 4.0) {
                                Toast.makeText(Main2Activity.this, "Nota EPR2 bajo 4.0, debes dar examen", Toast.LENGTH_SHORT).show();

                            } else {
                                if (epe2 < 4.0) {
                                    Toast.makeText(Main2Activity.this, "Nota EPE2 bajo 4.0, debes dar examen", Toast.LENGTH_SHORT).show();

                                } else {
                                    if (totalEvas < 4.0) {
                                        Toast.makeText(Main2Activity.this, "Promedio EVAS bajo 4.0, debes dar examen", Toast.LENGTH_SHORT).show();
                                    } else {

                                        if (presentacion < 5.5) {
                                            Toast.makeText(Main2Activity.this, "Promedio bajo 5.5, debes dar examen", Toast.LENGTH_SHORT).show();
                                        } else {

                                            notaExamen.setEnabled(false);


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }






            public boolean validarVacios(EditText... txts) {
                int c = 0;
                for (int i = 0; i < txts.length; i++) {
                    if (txts[c].getText().toString().isEmpty()) {
                        //JOptionPane.showMessageDialog(null, "Ingrese el campo requerido");
                        Toast.makeText(Main2Activity.this, "Ingresar Notas", Toast.LENGTH_SHORT).show();
                        txts[c].requestFocus();
                        c--;
                        break;
                    } else {
                        c++;
                    }
                }
                if (c == txts.length) {
                    return true;
                } else {
                    return false;
                }


                // cierra metodo

            }


        });



        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(volver);
            }

        });




        calculoFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarVacios(notaExamen)) {


                    //CalculoFinal
                    Double notaFinalPresentacion = presentacion * 0.70;

                    //Examen
                    Double notaFinalExamen = Double.parseDouble(notaExamen.getText().toString());
                    Double calculoExamen = notaFinalExamen * 0.30;

                    //PromedioFinal

                    Double promedioNotasFinal = redond(notaFinalPresentacion + calculoExamen);
                    String promNotasFinales = Double.toString(promedioNotasFinal);
                    promedioFinal.setText(promNotasFinales);

                }
            }



            public boolean validarVacios(EditText... txts) {
                int c = 0;
                for (int i = 0; i < txts.length; i++) {
                    if (txts[c].getText().toString().isEmpty()) {
                        //JOptionPane.showMessageDialog(null, "Ingrese el campo requerido");
                        Toast.makeText(Main2Activity.this, "Ingresar nota examen", Toast.LENGTH_SHORT).show();
                        txts[c].requestFocus();
                        c--;
                        break;
                    } else {
                        c++;
                    }
                }
                if (c == txts.length) {
                    return true;
                } else {
                    return false;
                }


                // cierra metodo

            }
        });

    }


    public static double redonde(double presentacion){
        long mult = (long) Math.pow(10, 1);
        double promedioN = (Math.round(presentacion * mult))/ (double) mult;
        return promedioN;


    }

    public static double redondear(double nExamen){
        long mult = (long) Math.pow(10, 1);
        double necExamen = (Math.round(nExamen * mult))/ (double) mult;
        return necExamen;


    }

    public static double redond(double promedioNotasFinal){
        long mult = (long) Math.pow(10, 1);
        double promedioFinal = (Math.round(promedioNotasFinal * mult))/ (double) mult;
        return promedioFinal;


    }


}


