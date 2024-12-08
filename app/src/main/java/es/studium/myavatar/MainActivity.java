package es.studium.myavatar;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView avatarImage;
    private TextView avatarDetails;
    private Avatar avatar; // Objeto Avatar
    private Button startDialogButton;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatarImage = findViewById(R.id.avatarImage);
        avatarDetails = findViewById(R.id.avatarDetails);
        startDialogButton = findViewById(R.id.startDialogButton);
        resetButton = findViewById(R.id.resetButton);

        avatar = new Avatar(); // Inicializar el objeto Avatar

        startDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoGenero(); // Inicia con el diálogo de género
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarAvatar(); // Restablece el avatar y la UI
            }
        });
    }

    // Método para obtener el avatar
    public Avatar getAvatar() {
        return avatar;
    }

    // Método para mostrar el diálogo de género
    private void mostrarDialogoGenero() {
        DialogoGenero dialogoGenero = new DialogoGenero();
        dialogoGenero.show(getSupportFragmentManager(), "DialogoGenero");
    }

    // Método para mostrar el diálogo de nombre después de elegir género
    public void mostrarDialogoNombre(String genero) {
        avatar.setGenero(genero);
        Log.d("MainActivity", "Género guardado: " + avatar.getGenero());

        DialogoNombre dialogoNombre = new DialogoNombre();
        dialogoNombre.show(getSupportFragmentManager(), "DialogoNombre");
    }

    // Método llamado cuando el nombre se ha ingresado
    public void mostrarDialogoEspecie(String nombre) {
        avatar.setNombre(nombre); // Guardar el nombre en el avatar
        DialogoEspecie dialogoEspecie = new DialogoEspecie(nombre);
        dialogoEspecie.show(getSupportFragmentManager(), "DialogoEspecie");
    }

    public void mostrarDialogoProfesion(String nombre, String especie) {
        avatar.setEspecie(especie); // Guardar la especie
        DialogoProfesion dialogoProfesion = new DialogoProfesion(nombre, especie);
        dialogoProfesion.show(getSupportFragmentManager(), "DialogoProfesion");
    }

    // Método para actualizar el avatar y mostrar los detalles en el TextView
    public void actualizarAvatar(String nombre, String genero, String especie, String profesion) {
        avatar.setNombre(nombre);
        avatar.setGenero(genero);
        avatar.setEspecie(especie);
        avatar.setProfesion(profesion);

        // Asegurarse de que el código esté correctamente estructurado
        Log.d("MainActivity", "Datos del Avatar: " +
                "Nombre: " + nombre +
                ", Género: " + genero +
                ", Especie: " + especie +
                ", Profesión: " + profesion);

        // Generar valores aleatorios para los poderes
        Random random = new Random();
        int vida = random.nextInt(101);  // Genera un número entre 0 y 100
        int magia = random.nextInt(11);  // Genera un número entre 0 y 10
        int fuerza = random.nextInt(21); // Genera un número entre 0 y 20
        int velocidad = random.nextInt(6); // Genera un número entre 0 y 5

        // Mostrar los detalles del avatar con los poderes en el TextView
        avatarDetails.setText("Nombre: " + avatar.getNombre() + "\n" +
                "Vida: " + vida + "\n" +
                "Magia: " + magia + "\n" +
                "Fuerza: " + fuerza + "\n" +
                "Velocidad: " + velocidad);

        // Asignar imagen de avatar (suponiendo que ya tienes este método)
        asignarImagenAvatar(genero, especie, profesion);
    }

    // Método para asignar la imagen del avatar
    private void asignarImagenAvatar(String genero, String especie, String profesion) {
        Log.d("AvatarGenero", "Género recibido: " + genero);
        Log.d("AvatarEspecie", "Especie recibida: " + especie);
        Log.d("AvatarProfesion", "Profesión recibida: " + profesion);

        if (genero.equals("Masculino")) {
            if (especie.equals("Elfo")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.m_elf_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.m_elf_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.m_elf_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.m_elf_blacksmith);
                }
            } else if (especie.equals("Enano")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.m_dwarf_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.m_dwarf_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.m_dwarf_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.m_dwarf_blacksmith);
                }
            } else if (especie.equals("Hobbit")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.m_hobbit_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.m_hobbit_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.m_hobbit_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.m_hobbit_blacksmith);
                }
            } else if (especie.equals("Humano")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.m_human_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.m_human_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.m_human_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.m_human_blacksmith);
                }
            }
        } else if (genero.equals("Femenino")) {
            if (especie.equals("Elfo")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.f_elf_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.f_elf_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.f_elf_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.f_elf_blacksmith);
                }
            } else if (especie.equals("Enano")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.f_dwarf_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.f_dwarf_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.f_dwarf_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.f_dwarf_blacksmith);
                }
            } else if (especie.equals("Hobbit")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.f_hobbit_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.f_hobbit_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.f_hobbit_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.f_hobbit_blacksmith);
                }
            } else if (especie.equals("Humano")) {
                if (profesion.equals("Arquero")) {
                    avatarImage.setImageResource(R.drawable.f_human_archer);
                } else if (profesion.equals("Guerrero")) {
                    avatarImage.setImageResource(R.drawable.f_human_warrior);
                } else if (profesion.equals("Mago")) {
                    avatarImage.setImageResource(R.drawable.f_human_mage);
                } else if (profesion.equals("Herrero")) {
                    avatarImage.setImageResource(R.drawable.f_human_blacksmith);
                }
            }
        } else {
            avatarImage.setImageResource(R.drawable.default_avatar);
        }
    }

    // Método para reiniciar el avatar
    private void reiniciarAvatar() {
        avatar = new Avatar(); // Resetear el avatar
        avatarDetails.setText(""); // Limpiar los detalles del avatar
        avatarImage.setImageResource(R.drawable.default_avatar); // Resetear la imagen
        startDialogButton.setVisibility(View.VISIBLE); // Asegurarse de que el botón "Crear avatar" esté visible
    }
}
