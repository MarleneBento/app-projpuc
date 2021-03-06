package com.projpuc.salaodebeleza.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.projpuc.salaodebeleza.R;
import com.google.android.material.textfield.TextInputEditText;
import com.projpuc.salaodebeleza.activitys.MenuActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment {

    public LogFragment() {
        // Required empty public constructor
    }
    private TextInputEditText varEmail, varSenha;
    private String email, senha;
    private Button btnEntrar;
    private TextView btnRecupSenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        varEmail = view.findViewById(R.id.txtEmailLog);
        varSenha = view.findViewById(R.id.txtSenhaLog);
        email = varEmail.getText().toString();
        senha = varSenha.getText().toString();
//        auth = ConfigFirebase.getFirebaseAuth();

        btnEntrar = view.findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationLogUser(email, senha);
            }
        });

        btnRecupSenha = view.findViewById(R.id.txtForgot);
        btnRecupSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRecupSenha();
            }
        });

        return view;
    }

    public void abrirRecupSenha(){
//        Intent i = new Intent(getActivity(), ResetPasswordActivity.class);
//        startActivity(i);
    }

    public void validationLogUser(String email, String senha) {
        String txtEmail = varEmail.getText().toString();
        String txtSenha = varSenha.getText().toString();


        if (txtEmail.isEmpty() && txtSenha.isEmpty()) {
            Toast.makeText(getActivity(),
                    "Preencha TODOS os campos!",
                    Toast.LENGTH_LONG).show();
        }
        else{
            if (!txtEmail.isEmpty()) {
                if (!txtSenha.isEmpty()) {
//                    Usuario usuario = new Usuario();
//                    usuario.setEmail(txtEmail);
//                    usuario.setSenha(txtSenha);

                    logUser();

                } else {
                    Toast.makeText(getActivity(),
                            "Senha n??o preenchida!",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(),
                        "E-mail n??o preenchido!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
    public void logUser(){
        getActivity().finish();
                   Intent intent = new Intent(getContext().getApplicationContext(), MenuActivity.class);
                   startActivity(intent);
    }
//    public void logUser(Usuario usuario){
//        auth.signInWithEmailAndPassword(
//                usuario.getEmail(),
//                usuario.getSenha()
//        ).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>(){
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                if(task.isSuccessful()){
//                    Toast.makeText(getActivity(),
//                            "Sucesso ao logar!",
//                            Toast.LENGTH_LONG).show();
//                    getActivity().finish();
//                    Intent intent = new Intent(getContext().getApplicationContext(), MenuInferiorActivity.class);
//                    startActivity(intent);
//                }
//                else{
//                    String excecao = "";
//                    try{
//                        throw task.getException();
//                    }catch (FirebaseAuthInvalidUserException e){
//                        excecao ="Usu??rio n??o est?? cadastrado";
//                    }catch (FirebaseAuthInvalidCredentialsException e){
//                        excecao = "E-mail e senha n??o correspondem a usu??rio cadastrado";
//                    }catch (FirebaseAuthUserCollisionException e){
//                        excecao = "Essa conta j?? foi cadastrada";
//                    }catch (Exception e){
//                        excecao = "Erro ao logar usu??rio: " + e.getMessage();
//                        e.printStackTrace();
//                    }
//                    Toast.makeText(getActivity(),
//                            excecao,
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }


}
