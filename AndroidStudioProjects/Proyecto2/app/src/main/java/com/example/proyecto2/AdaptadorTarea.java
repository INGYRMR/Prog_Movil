package com.example.proyecto2;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdaptadorTarea extends RecyclerView.Adapter<AdaptadorTarea.TareaViewHolder> {

    private ArrayList<Tarea> listaTareas;

    public AdaptadorTarea(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TareaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = listaTareas.get(position);
        holder.tituloTarea.setText(tarea.getTitulo());

        // Tachado si está completada
        holder.tituloTarea.setPaintFlags(tarea.estaCompletada() ?
                holder.tituloTarea.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG :
                holder.tituloTarea.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);

        // Cambiar estado completada al tocar el texto
        holder.tituloTarea.setOnClickListener(v -> {
            tarea.cambiarEstado();
            notifyItemChanged(position);
        });

        // Eliminar tarea
        holder.botonEliminar.setOnClickListener(v -> {
            listaTareas.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    static class TareaViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTarea;
        Button botonEliminar;

        TareaViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTarea = itemView.findViewById(R.id.titulo_tarea);
            botonEliminar = itemView.findViewById(R.id.boton_eliminar);
        }
    }
}
