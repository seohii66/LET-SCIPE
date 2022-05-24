package com.example.letscipe;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FridgeAdapter extends RecyclerView.Adapter<FridgeAdapter.ViewHolder> {
    private List<Fridge> dataList;
    private Activity context;
    private MyRoomDb database;

    public FridgeAdapter(Activity context, List<Fridge> dataList)
    {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FridgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fridge_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FridgeAdapter.ViewHolder holder, int position) {
        final Fridge fridge = dataList.get(position);
        database = MyRoomDb.getInstance(context);
        holder.textView.setText(fridge.getIngredient());
        holder.btEdit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Fridge fridge1 = dataList.get(holder.getAdapterPosition());

                final int sID = fridge1.getId();
                String sText = fridge1.getIngredient();

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.fridge_update_dlg);

                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.getWindow().setLayout(width, height);

                dialog.show();

                final EditText editText = dialog.findViewById(R.id.dialog_edit_text);
                Button bt_update = dialog.findViewById(R.id.bt_update);

                editText.setText(sText);

                bt_update.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        String uText = editText.getText().toString().trim();

                        database.fridgeDao().update(sID, uText);

                        dataList.clear();
                        dataList.addAll(database.fridgeDao().getALL());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        /* 삭제 클릭 */
        holder.btDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fridge fridge1 = dataList.get(holder.getAdapterPosition());

                database.fridgeDao().delete(fridge1);

                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView btEdit, btDelete;

        public ViewHolder(@NonNull View view)
        {
            super(view);
            textView = view.findViewById(R.id.text_view);
            btEdit = view.findViewById(R.id.bt_edit);
            btDelete = view.findViewById(R.id.bt_delete);
        }
    }
}
