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

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class FinishedTasks extends Fragment implements Adapter.AdapterCallback{

    private List<TaskCreator> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter adapter;

    public static FinishedTasks newInstance() {

        Bundle args = new Bundle();

        FinishedTasks fragment = new FinishedTasks();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView = getActivity().findViewById(R.id.finished_recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(taskList, this);
        recyclerView.setAdapter(adapter);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.finished_tasks, container, false);
        ButterKnife.bind(this, view);

        return view;

    }


    @Override
    public void rowLongClicked(TaskCreator taskCreator) {

    }

    @Override
    public void addClicked(TaskCreator taskCreator) {

    }
}
