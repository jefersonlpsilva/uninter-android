package app.dinamismo.cadastroAmigos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.IntegerRes;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO_DADOS = "CadastroAmigos";
    private static final int VERSAO_BANCO_DADOS = 1;

    public DBHelper(Context context) {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // comando sql responsavel pela cricao da estrutura da tabela amigos
        String tabela_amigos = "CREATE TABLE amigos("
                +" id INTEGER PRIMARY KEY autoincrement,"
                +" nome TEXT,"
                +" telefone TEXT,"
                +" email TEXT "
                +")";
        //executando o sql da tabela amigos
        sqLiteDatabase.execSQL(tabela_amigos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void inserir(Amigo amigo){
        //Abri conexao
        SQLiteDatabase db = this.getWritableDatabase();
        //statement sql
        SQLiteStatement stmt = db.compileStatement("INSERT INTO amigos(nome, telefone, email) values (?, ?, ?)");
        //passagem de valor para o statement
        stmt.bindString(1,amigo.getNome());
        stmt.bindString(2,amigo.getTelefone());
        stmt.bindString(3,amigo.getEmail());
        //executa comando sql
        stmt.execute();
        //fecha stmt
        stmt.close();
        //fecha db
        db.close();
    }

    public void atualizar(Amigo amigo){
        //Abri conexao
        SQLiteDatabase db = this.getWritableDatabase();
        //statement sql
        SQLiteStatement stmt = db.compileStatement("UPDATE amigos SET nome = ? , telefone = ? , email = ? WHERE id = ? ");
        //passagem de valor para o statement
        stmt.bindString(1,amigo.getNome());
        stmt.bindString(2,amigo.getTelefone());
        stmt.bindString(3,amigo.getEmail());
        stmt.bindLong(4,amigo.getId());
        //executa comando sql
        stmt.execute();
        //fecha stmt
        stmt.close();
        //fecha db
        db.close();
    }

    public void excluir(int id){
        //Abri conexao
        SQLiteDatabase db = this.getWritableDatabase();
        //statement sql
        SQLiteStatement stmt = db.compileStatement("DELETE FROM amigos WHERE id = ? ");
        //passagem de valor para o statement
        stmt.bindLong(1, id);
        //executa comando sql
        stmt.execute();
        //fecha stmt
        stmt.close();
        //fecha db
        db.close();
    }

    public Amigo retornaAmigo(int id) {
        //Abri conexao
        SQLiteDatabase db = this.getWritableDatabase();
        //String query
        String query = "SELECT id, nome, telefone, email FROM amigos WHERE id = ?";
        //Cursor resultado retornado
        Cursor cursor = db.rawQuery(query, new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        //
        Amigo amigo = new Amigo();
        //defini as propriedades com base nas colunas existentes do cursor
        amigo.setId(cursor.getInt(0));
        amigo.setNome(cursor.getString(1));
        amigo.setEmail(cursor.getString(2));
        //fecha db
        db.close();
        return amigo;
    }

    public ArrayList<Amigo> listar() {
        // criamos uma List que armazenará objetos do tipo Amigo
        ArrayList amigos = new ArrayList<Amigo>();
        // abrimos a conexão com o arquivo que armazena o banco de dados
        SQLiteDatabase db = this.getWritableDatabase();
        // Buscamos todos os registros disponiveis no banco de dados ordenados por nome
        String query = "Select id, nome, telefone, email FROM amigos ORDER BY nome";
        Cursor cursor = db.rawQuery(query, null);
        // iteramos por todos os registros localizados com base em nossa query
        while (cursor.moveToNext()) {
            // instanciamos um novo objeto amigo
            Amigo amigo = new Amigo();

            // preenchemos este objeto com os valores armazenados no cursor
            amigo.setId(cursor.getInt(0));
            amigo.setNome(cursor.getString(1));
            amigo.setTelefone(cursor.getString(2));
            amigo.setEmail(cursor.getString(3));
            // adicionamos o objeto preenchido à nossa List de amigos
            amigos.add(amigo);
        }
        return amigos;
    }
}
