package app.dinamismo.cadastroAmigos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AmigoAdapter extends BaseAdapter {

    //dados que Adapter recebe
    private List<Amigo> amigos;
    //Contexto
    Context context = null;
    // responsavel por inflar/rederizar o layout
    private LayoutInflater inflater;
    // inicializa os objetos declarados
    public AmigoAdapter(Context context, List<Amigo> amigos){
        this.amigos = amigos;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.amigos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.amigos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Atribuímos ao objeto Amigo o registro localizado em nosso método getItem(pos)
        final Amigo amigo = (Amigo) getItem(position);


        // caso nosso objeto View não possua um layout atribuído a ele, instanciamos o mesmo, passando como
        // argumento o layout que utilizaremos para representar um registro
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.amigo_layout, null);
        }

        // instanciamos os objetos que corresponderão aos componentes em nosso layout
        // instanciamos os objetos que corresponderão aos componentes em nosso layout
        TextView idAmigo = (TextView) convertView.findViewById(R.id.txtIDAmigo);
        TextView nomeAmigo = (TextView) convertView.findViewById(R.id.txtNomeAmigo);
        TextView telefoneAmigo = (TextView) convertView.findViewById(R.id.txtTelefoneAmigo);
        TextView emailAmigo = (TextView) convertView.findViewById(R.id.txtEmailAmigo);

        // iniciamos estes objetos
        idAmigo.setText(String.valueOf(amigo.getId()));
        nomeAmigo.setText(amigo.getNome());
        telefoneAmigo.setText(amigo.getTelefone());

        return convertView;
    }
}
