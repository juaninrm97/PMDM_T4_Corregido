package es.studium.myavatar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Usamos un inflater para inflar el layout del diálogo
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_nombre, null);

        EditText nombreEditText = view.findViewById(R.id.nombreEditText);
        Button aceptarButton = view.findViewById(R.id.aceptarButton);

        // Acción al hacer click en el botón de aceptar
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString().trim();  // Obtener el texto del EditText

                if (!nombre.isEmpty()) {
                    // Llamamos al método en MainActivity para continuar con el flujo
                    if (getActivity() instanceof MainActivity) {
                        ((MainActivity) getActivity()).mostrarDialogoEspecie(nombre);
                    }
                    dismiss();  // Cerrar el diálogo después de hacer la actualización
                } else {
                    // Si el nombre está vacío, mostramos un mensaje de error (opcional)
                    nombreEditText.setError(getString(R.string.name_empty_error));
                }
            }
        });

        return new android.app.AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }
}
