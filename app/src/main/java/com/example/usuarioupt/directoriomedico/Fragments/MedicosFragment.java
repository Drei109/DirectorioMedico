package com.example.usuarioupt.directoriomedico.Fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.usuarioupt.directoriomedico.Datos.MedicosCursorAdapter;
import com.example.usuarioupt.directoriomedico.Datos.MedicosDbHelper;
import com.example.usuarioupt.directoriomedico.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicosFragment extends Fragment {

    private ListView mMedicosList;
    private CursorAdapter mMedicosAdapter;
    private FloatingActionButton mAddButton;
    private MedicosDbHelper mMedicosDbHelper;

    public MedicosFragment() {
        // Required empty public constructor
    }

    public static MedicosFragment newInstance() {
        return new MedicosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_medicos,container,false);

        // Referencia UI
        mMedicosList = (ListView)root.findViewById(R.id.medicos_list);
        mMedicosAdapter = new MedicosCursorAdapter(getActivity(),null);
        mAddButton = (FloatingActionButton)getActivity().findViewById(R.id.fab);

        // Configurar
        mMedicosList.setAdapter(mMedicosAdapter);

        // Instancia de helper
        mMedicosDbHelper = new MedicosDbHelper(getActivity());

        // Carga de datos
        loadMedicos();

        return root;
    }

    private void loadMedicos() {
        new MedicosLoadTask().execute();
    }

    private class MedicosLoadTask extends AsyncTask<Void,Void,Cursor>{
        @Override
        protected Cursor doInBackground(Void... voids){
            return mMedicosDbHelper.getAllMedicos();
        }

        @Override
        protected void onPostExecute(Cursor c){
            if(c != null && c.getCount() > 0){
                mMedicosAdapter.swapCursor(c);
            }else{
                //Mostrar empty state
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){

    }

}
