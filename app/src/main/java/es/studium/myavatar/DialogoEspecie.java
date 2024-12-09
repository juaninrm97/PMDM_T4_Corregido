package es.studium.myavatar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        // Inflamos el layout del diálogo
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_especie, null);

        Spinner especieSpinner = view.findViewById(R.id.especieSpinner);
        Button continuarButton = view.findViewById(R.id.aceptarButton);

        // Crear un ArrayAdapter para llenar el Spinner con las especies
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.especies_array, // Referencia al array de especies
                android.R.layout.simple_spinner_item // Layout para cada ítem
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Estilo del dropdown
        especieSpinner.setAdapter(adapter);

        // Acción al hacer click en el botón de continuar
        continuarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String especieSeleccionada = especieSpinner.getSelectedItem().toString();

                if (!especieSeleccionada.equals("Selecciona una especie")) {
                    // Si se ha seleccionado una especie válida, pasamos al siguiente paso
                    ((MainActivity) getActivity()).mostrarDialogoProfesion(nombre, especieSeleccionada);
                    dismiss();  // Cerrar el diálogo
                } else {
                    // Si no se ha seleccionado ninguna especie, mostramos un mensaje
                    Toast.makeText(getActivity(), "Por favor, selecciona una especie.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Construir y devolver el diálogo
        return new android.app.AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Cancelar", null) // Opción de cancelar
                .create();
    }
}
