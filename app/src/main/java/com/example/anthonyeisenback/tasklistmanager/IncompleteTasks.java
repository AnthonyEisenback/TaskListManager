package com.example.anthonyeisenback.tasklistmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anthonyeisenback.tasklistmanager.Room.TaskDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncompleteTasks extends Fragment implements Adapter.AdapterCallback{
    private Adapter adapter;
    private RecyclerView recyclerView;
    private List<TaskCreator> taskList = new ArrayList<>();
    private Adapter.AdapterCallback adapterCallback;


    public static IncompleteTasks newInstance() {

        Bundle args = new Bundle();

        IncompleteTasks fragment = new IncompleteTasks();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        startRecyclerView();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.incomplete_tasks, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    private void startRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView = getActivity().findViewById(R.id.recycler_View_example);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(taskList, adapterCallback);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void rowLongClicked(TaskCreator taskCreator) {

    }

    @Override
    public void addClicked(TaskCreator taskCreator) {

    }
}
