package br.com.danielcastro.persistencia


import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import br.com.danielcastro.persistencia.dao.BancoDeDados
import br.com.danielcastro.persistencia.model.Game



class NovoGameDialog : DialogFragment() {

    private lateinit var builder: AlertDialog.Builder
    private lateinit var etGame: EditText
    private lateinit var spPlataforma: Spinner

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        builder = AlertDialog.Builder(activity)

        val v = activity.layoutInflater.inflate(R.layout.novo_game_dialog, null)

        etGame = v.findViewById(R.id.etGame)
        spPlataforma = v.findViewById(R.id.spPlataforma)

        builder.setView(v)
        builder.setTitle("Novo Game")
        builder.setPositiveButton("Adicionar") { _, _ ->
            val db = BancoDeDados.getDatabase(activity.applicationContext)
            val game = Game(etGame.text.toString(),
                    spPlataforma.selectedItem.toString())
            if (game.nome != "")
                InsertAsyncTask(db!!).execute(game)
        }
        builder.setNegativeButton("Cancelar", null)
        return builder.create()
    }

    private inner class InsertAsyncTask internal constructor(appDatabase: BancoDeDados) : AsyncTask<Game, Void, String>() {
        private val db: BancoDeDados = appDatabase

        override fun doInBackground(vararg params: Game): String {
            db.gameDAO().inserir(params[0])
            return ""
        }
    }

}