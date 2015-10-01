package com.edwinacubillos.ejlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView lstNombres;

    private Lista_Entrada[] datos =
        new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.supermanlogo, "Superman", "Clak Kent", "1938"),
            new Lista_Entrada(R.drawable.flashlogo, "Flash", "Barry Allen","1940"),
            new Lista_Entrada(R.drawable.mujermaravillalogo, "Mujer Maravilla", "Diana", "1941"),
            new Lista_Entrada(R.drawable.acuamanlogo,"Acuaman","Arthur Curry", "1941")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // final String[] nombre = new String[] {"Superman", "Flash", "Mujer Maravilla", "Acuaman"};

        //adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombre);

        Adapter adaptador = new Adapter(this, datos);

        lstNombres = (ListView) findViewById(R.id.Lst);

        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

                Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();

            }
        });

     /*   lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, String.valueOf(parent.getItemAtPosition(position)),Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.layout_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView nombrePila = (TextView) item.findViewById(R.id.tNombrePila);
            nombre.setText(datos[position].getNombrePila());

            TextView fecha = (TextView) item.findViewById(R.id.fecha);
            nombre.setText(datos[position].getFecha());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
