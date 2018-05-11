package com.example.anthonyeisenback.tasklistmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anthonyeisenback.tasklistmanager.Room.TaskDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by rodneytressler on 12/17/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.TaskViewHolder> {

    private List<TaskCreator> taskCreatorList;
    private AdapterCallback adapterCallback;
    private TaskDatabase database;
    private TaskCreator taskCreator;

    public Adapter(List<TaskCreator> taskCreatorList, AdapterCallback adapterCallback) {
        this.taskCreatorList = taskCreatorList;
        this.adapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bind(position);


    }


    @Override
    public int getItemCount() {
        return taskCreatorList.size();
    }

    public void updateList(List<TaskCreator> list) {
        taskCreatorList = list;
        notifyDataSetChanged();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task_desciption_edittext)
        protected TextView taskDescription;

        @BindView(R.id.task_name)
        protected TextView taskName;

        @BindView(R.id.date_textview)
        protected TextView dateText;


        public TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        public View.OnClickListener onClick(final TaskCreator taskCreator) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterCallback.addClicked(taskCreator);
                }
            };
        }


        public void bind(int position) {
//            taskDescription.setText(taskCreatorList.get(position).getTaskDescription());
//            taskName.setText(taskCreatorList.get(position).getTaskName());
        }


    }

    public interface AdapterCallback {
        void rowLongClicked(TaskCreator taskCreator);
        void addClicked(TaskCreator taskCreator);

    }

}
