package es.studium.myavatar;

import android.widget.Toast;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoGenero extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_genero, null);

        RadioGroup radioGroupGenero = view.findViewById(R.id.radioGroupGenero);
        Button btnAceptar = view.findViewById(R.id.btnAceptarGenero);

        builder.setView(view);

        AlertDialog dialog = builder.create();



        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupGenero.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton radioButton = view.findViewById(selectedId);
                    String generoSeleccionado = radioButton.getText().toString().trim();
                    Log.d("DialogoGenero", "Género seleccionado: " + generoSeleccionado);

                    ((MainActivity) requireActivity()).mostrarDialogoNombre(generoSeleccionado);
                    dialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), "Por favor, selecciona un género.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return dialog;
    }
}
