package es.studium.myavatar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment {

    private String nombre; // Recibimos el nombre desde el MainActivity

    // Constructor con el nombre
    public DialogoEspecie(String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] especies = {"Elfo", "Enano", "Hobbit", "Humano"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecciona una Especie")
                .setItems(especies, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String especie = especies[which];
                        // Pasar el nombre y la especie a MainActivity
                        ((MainActivity) getActivity()).mostrarDialogoProfesion(nombre, especie);
                    }
                })
                .setNegativeButton("Cancelar", null);

        return builder.create();
    }
}
