package co.edu.unab.martinez.andrea.seriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_usuario;
    private EditText txt_contra;
    private Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_usuario= findViewById(R.id.txt_usuario);
        txt_contra= findViewById(R.id.txt_contra);

        btn_ingresar =findViewById(R.id.btn_ingresar);


        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_usuario.getText().toString().isEmpty()||txt_contra.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Los campos estan incompletos",Toast.LENGTH_SHORT).show();
                }
                if(txt_usuario.getText().toString().matches(getString(R.string.user)) && txt_contra.getText().toString().matches(getString(R.string.pwd)) ){
                    Toast.makeText(getApplicationContext(),"Bienvenid@ "+getString(R.string.user),Toast.LENGTH_SHORT).show();

                    Intent miIntencion = new Intent(getApplication(),ListadoActivity.class);
                    miIntencion.putExtra("usuario",getString(R.string.user));
                    startActivity(miIntencion);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Los datos ingresados son incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
