package com.example.anthonyeisenback.tasklistmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.anthonyeisenback.tasklistmanager.Room.TaskDatabase;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTask extends Fragment{

    private TaskDatabase database;

    private Adapter incompleteTaskAdapter;

    @BindView(R.id.task_desciption_edittext)
    protected EditText taskNameEdittext;

    @BindView(R.id.add_name_to_game_editText)
    protected EditText descriptionEdittext;

    private List<TaskCreator> taskCreatorList;
    private ActivityCallback activityCallback;


    public static AddTask newInstance() {

        Bundle args = new Bundle();

        AddTask fragment = new AddTask();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_task_layout, container, false);
        ButterKnife.bind(this, view);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        database = ((DatabaseApplication) getActivity().getApplicationContext()).getDatabase();

    }

    @OnClick(R.id.add_task_to_list_floating_button)
    protected void addTask( ) {

        String taskName = taskNameEdittext.getText().toString();
        String description = descriptionEdittext.getText().toString();

        if (TextUtils.isEmpty(taskName) || TextUtils.isEmpty(description)) {
            Toast.makeText(getContext(), "Please Fill out All Fields", Toast.LENGTH_LONG).show();
        } else {
            addTaskToDatabase(taskNameEdittext.getText().toString(), descriptionEdittext.getText().toString());
        }
    }

    private void addTaskToDatabase(final String taskName, final String description) {
        TaskCreator taskCreator = new TaskCreator(taskName, description, false, new Date());
        database.taskDAO().addTask(taskCreator);
        activityCallback.addClicked();
    }

    public void attachParent(ActivityCallback activityCallback) {
        this.activityCallback = activityCallback;
    }

    public interface ActivityCallback {
        void addClicked();

    }
}
