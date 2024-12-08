package es.studium.myavatar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoProfesion extends DialogFragment {

    private String nombre;
    private String especie;

    // Constructor con nombre y especie
    public DialogoProfesion(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Usamos un inflater para inflar el layout del diálogo
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_profesion, null);

        Spinner profesionSpinner = view.findViewById(R.id.profesionSpinner);
        Button aceptarButton = view.findViewById(R.id.aceptarButton);
        TextView errorTextView = view.findViewById(R.id.errorTextView); // Referencia al TextView de error

        // Crear un ArrayAdapter para llenar el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.profesiones_array, // Referencia al array de profesiones
                android.R.layout.simple_spinner_item // Layout para cada ítem
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Estilo del dropdown
        profesionSpinner.setAdapter(adapter);

        // Acción al hacer click en el botón de aceptar
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si el Spinner tiene un valor seleccionado
                if (profesionSpinner.getSelectedItem() != null) {
                    String profesionSeleccionada = profesionSpinner.getSelectedItem().toString();

                    // Comprobar si la actividad es una instancia de MainActivity antes de hacer el cast
                    if (getActivity() instanceof MainActivity) {
                        // En el método donde necesitas acceder a avatar
                        MainActivity mainActivity = (MainActivity) getActivity(); // Obtiene la referencia de MainActivity
                        String genero = mainActivity.getAvatar().getGenero();  // Ahora puedes acceder al avatar a través del getter

                        mainActivity.actualizarAvatar(nombre, genero, especie, profesionSeleccionada);
                        dismiss();  // Cerrar el diálogo después de actualizar
                    }

                } else {
                    // Mostrar el mensaje de error en el TextView
                    errorTextView.setVisibility(View.VISIBLE); // Hacer visible el error
                }
            }
        });

        return new android.app.AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }
}
