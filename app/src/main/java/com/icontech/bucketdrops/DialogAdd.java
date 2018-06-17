package com.icontech.bucketdrops;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.icontech.bucketdrops.beans.Drop;

import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;
import io.realm.RealmConfiguration;


public class DialogAdd extends DialogFragment {
    EditText dropEditText;
    ImageView dropClose;
    DatePicker dropDatePicker;
    Button dropAdditButton;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.dropAdditButton:
                    getWhatisit();
                    break;
            }

            dismiss();
        }
    };

    private void getWhatisit() {
        String what= dropEditText.getText().toString();
        long now= System.currentTimeMillis();

        Realm.init(getActivity());
        RealmConfiguration configuration= new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
        Realm realm =Realm.getDefaultInstance();
        Drop drop = new Drop(what,now,0,false);
        realm.beginTransaction();
        realm.copyToRealm(drop);
        realm.commitTransaction();
        realm.close();

    }

    public DialogAdd() {
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_xml,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dropEditText = (EditText) view.findViewById(R.id.dropEditText);
        dropClose=(ImageView) view.findViewById(R.id.dropClose);
        dropDatePicker=(DatePicker)view.findViewById(R.id.dropDatePicker);
        dropAdditButton=(Button)view.findViewById(R.id.dropAdditButton);

        dropClose.setOnClickListener(clickListener);
        dropAdditButton.setOnClickListener(clickListener);


    }


}
