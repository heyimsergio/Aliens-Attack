package dadm.scaffold.counter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import dadm.scaffold.BaseFragment;
import dadm.scaffold.R;
import dadm.scaffold.ScaffoldActivity;
import dadm.scaffold.engine.ViewModel;


public class MainMenuFragment extends BaseFragment implements View.OnClickListener {
    public MainMenuFragment() {
    }

    ViewModel viewModel ;

    ImageButton nave1;
    ImageButton nave2;

    public int naveSeleccionada = 0; //0 ninguna, 1  una y 2 la segunda

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        viewModel = ViewModelProviders.of(getScaffoldActivity()).get(ViewModel.class);

        nave1 = rootView.findViewById(R.id.imageButton);
        nave2 = rootView.findViewById(R.id.imageButton2);
        naveSeleccionada = 0;

        nave1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                seleccionarNave1();
            }
        });

        nave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleccionarNave2();
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (naveSeleccionada != 0) {

            viewModel.setNave(naveSeleccionada);
            ((ScaffoldActivity) getActivity()).startGame();
        } else {
            Toast.makeText(this.getContext(), "Debes seleccionar una nave",Toast.LENGTH_SHORT).show();
        }
    }

    public void seleccionarNave1(){
        viewModel.setNave(naveSeleccionada);
        naveSeleccionada = 1;
    }

    public void seleccionarNave2(){
        viewModel.setNave(naveSeleccionada);
        naveSeleccionada = 2;
    }
}
