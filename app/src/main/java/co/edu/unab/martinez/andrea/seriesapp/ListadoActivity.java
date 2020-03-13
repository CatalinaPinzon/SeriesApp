package co.edu.unab.martinez.andrea.seriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    private RecyclerView rvSeries;
    private ArrayList<Serie> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Bundle data = getIntent().getExtras();

        rvSeries = findViewById(R.id.rv_Series);
        this.getFakeData();

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplication(),2);

        SerieAdapter miAdaptador = new SerieAdapter(series, new SerieAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Serie miserie, int posicion) {
                Intent miIntencion = new Intent(getApplication(),DetalleActivity.class);
                miIntencion.putExtra("serie",series.get(posicion).getNombre());
                miIntencion.putExtra("conSerie", series.get(posicion));
                startActivity(miIntencion);
            }
        }); // Creación del adaptador.

        rvSeries.setLayoutManager(manager);
        rvSeries.setAdapter(miAdaptador);


        setTitle("Listado de Series - " + data.getString("usuario"));


    }
    private void getFakeData(){

        if(series==null){
            series = new ArrayList<>();
        }
        series.add(new Serie("No game No Life","La historia está protagonizada por Sora y Shiro, hermano y hermana, que son muy famosos en todo Internet como NEETs y hikikomoris que se pasan el día jugando a videojuegos, tanto que son una leyenda.", "https://img1.ak.crunchyroll.com/i/spire1/5a4525c6fc5508fa27f0ed229ad2cbde1396985147_full.jpg","https://www.smashmexico.com.mx/wp-content/uploads/2018/02/La-vida-es-un-juego-No-Game-No-Life-Zero-cover.jpg","Yoshitsugu Matsuoka as Sora,Ai Kayano as Shiro,Yōko Hikasa as Stephanie Dola,Yukari Tamura as Jibril"));
        series.add(new Serie("Fairy Tail", "Lucy Heartfilia es una joven decidida a unirse al gremio de magos Fairy Tail. En su recorrido conocerá a Natsu, que es parte del gremio y que le ofrece entrar a formar parte de sus filas.","https://cdn.atomix.vg/wp-content/uploads/2018/09/FairyTailPoster_anime.jpg","https://publimetro.pe/resizer/3SeKYZluLUAzswbK35v9JL26g18=/980x528/smart/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/DINJ4FE2OREJ5FVKHBQLNPX77I.jpg","Tetsuya Kakihara as Natsu Dragneel,Aya Hirano as Lucy Heartfilia,Rie Kugimiya as Happy,Yūichi Nakamura as Gray Fullbuster"));
        series.add(new Serie("Death Parade","“Bienvenidos al Queen Dekim”. Un bar y su camarero, Dekim, son los que reciben a dos incautos visitantes. “Ahora que estáis aquí, los dos empezaréis una batalla donde vuestra vida estará en juego”, les dice Dekim para presentar el Death Game. En poco tiempo, se desvelan las verdaderas naturalezas de los dos contendientes.","https://3.bp.blogspot.com/-gtbkPFnR5P0/VaMUgpmto-I/AAAAAAAABw4/kLbbnAXUorY/s1600/Death-Parade-OST.jpg","https://miro.medium.com/max/2732/1*A5zaApI0hdCHmuy4KC93DQ.png","Tomoaki Maeno as Decim,Asami Seto as Chiyuki,Rumi Okubo as Nona,Yoshimasa Hosoya as Ginty"));
        series.add(new Serie("Violet Evergarden","Violet, una soldado emocionalmente separada que recibió armas protésicas después de una lesión en combate, se instala en la vida de posguerra como una escritora fantasma.","https://pm1.narvii.com/6699/9fa6171ad28d877b3435826e93ffde863b963723_hq.jpg","https://cde.laprensa.e3.pe/ima/0/0/1/8/9/189153.jpg","Yui Ishikawa as Violet Evergarden,Takehito Koyasu as Claudia Hodgins,Daisuke Namikawa as Gilbert Bougainvillea,Aya Finō as Cattleya Baudelaire"));
        series.add(new Serie("Golden Time","Banri Tada es un estudiante nuevo en una escuela privada de leyes en Tokio. Sin embargo, debido a un accidente, pierde la memoria. Durante su orientación como novato conoce a Mitsuo Yanagisawa, y de primera ya congenian. Sin recordarse el uno al otro, sus vidas se van entrelazando poco a poco por el destino. Pero ¿a qué llevará todo esto?","https://vignette.wikia.nocookie.net/manga/images/a/ab/Golden_Time.jpg/revision/latest/scale-to-width-down/340?cb=20140624183742&path-prefix=es","https://lh3.googleusercontent.com/proxy/gmxhm04PNy3sNH02mloLty-TxsR1cKyN5FDGkVwh_4noRKBSvay8b6IX3ESue8BXjuzWrWw5NIocHAqWUtmuC00e8KVVm-LFlDdWuc3sFdqa","Makoto Furukawa as Banri Tada,Yui Horie as Koko,Kaito Ishikawa as Mitsuo Yanagisawa,Ai Kayano as Rinda Hayashida"));
        series.add(new Serie("Your Lie in April","Arima Kosei es un prodigio del piano, y cualquier niño músico del mundo conoce su nombre, pero cuando su madre y también maestra fallece, se desmorona en mitad de un recital y desde ese momento es completamente incapaz de escuchar el sonido de su piano aunque no tenga problemas de oído. Dos años después, Kosei sigue sin tocar un piano y ve el mundo como algo monótono, sin color. Se conformaba con llevar una vida tranquila junto a sus amigos Tsubaki y Watari, al menos hasta que una chica lo cambia todo: Miyazono Kaori.","https://img1.ak.crunchyroll.com/i/spire3/40e6c04e05ce1efb08815b870a6d39331412797514_full.jpg","https://1.bp.blogspot.com/-jjMdHpVwIBc/Ws5_DAfjTjI/AAAAAAAAMFM/iIbWzd-XFdMBgfYgR05K2oq44ZjtkqHJwCLcBGAs/s1600/origin.jpg","Natsuki Hanae as Kōsei Arima,Risa Taneda as Kaori Miyazono,Ayane Sakura as Tsubaki Sawabe,Ryōta Ōsaka as Ryōta Watari"));



    }

}
