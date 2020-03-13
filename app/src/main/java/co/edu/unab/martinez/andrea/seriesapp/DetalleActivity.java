package co.edu.unab.martinez.andrea.seriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    private ImageView imgvDetail;
    private TextView txtDescripcion;
    private ListView lvCast;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> cast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Bundle data = getIntent().getExtras();
        setTitle("Serie - "+ data.getString("serie"));

        imgvDetail = findViewById(R.id.imgv_detail);
        txtDescripcion = findViewById(R.id.txt_descripcion);
        lvCast =findViewById(R.id.lv_cast);

        Serie conSerie = (Serie)data.get("conSerie");

        Picasso.get().load(conSerie.getUrldetail()).into(imgvDetail);

        txtDescripcion.setText(conSerie.getDescripcion());
        cast = conSerie.getElenco();

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txt_item,cast);

        lvCast.setAdapter(adapter);
    }

}
