package com.example.mydatabase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Student>studentList;

    public RecyclerViewAdapter(Context context, List<Student> studentList){
        this.context = context;
        this.studentList = studentList;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        Log.d("main", "onCreateViewHolder: addedddd");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.department.setText(student.getDepartment());
        holder.school.setText(student.getSchool());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,department,school;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameEd);
            department = itemView.findViewById(R.id.departmentEd);
            school = itemView.findViewById(R.id.schoolEd);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Student student = studentList.get(position);


                    Toast.makeText(context, "position "+ student.getDepartment(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,DetailsActivity.class);
                    intent.putExtra("name",student.getName());
                    intent.putExtra("department",student.getDepartment());
                    intent.putExtra("school",student.getSchool());
                    context.startActivity(intent);
                }
            });


        }
    }
}
