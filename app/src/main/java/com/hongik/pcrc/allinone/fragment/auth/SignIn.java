package com.hongik.pcrc.allinone.fragment.auth;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hongik.pcrc.allinone.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment {

    interface Callbacks {
        void onSignInSelected();
        void onResetPasswordSelected();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Callbacks callbacks;

    private ImageButton backArrow;
    private EditText idInput;
    private EditText passwordInput;
    private Button acceptSignIn;
    private TextView signUp;
    private TextView resetPassword;

    public SignIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignIn.
     */
    // TODO: Rename and change types and number of parameters
    public static SignIn newInstance(String param1, String param2) {
        SignIn fragment = new SignIn();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        backArrow = view.findViewById(R.id.login_back_button);
        idInput = view.findViewById(R.id.login_id_input);
        passwordInput = view.findViewById(R.id.login_password_input);
        acceptSignIn = view.findViewById(R.id.login_accept_button);
        signUp = view.findViewById(R.id.login_sign_up);
        resetPassword = view.findViewById(R.id.login_reset_password_button);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        TextWatcher idWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        TextWatcher passwordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        idInput.addTextChangedListener(idWatcher);
        passwordInput.addTextChangedListener(passwordWatcher);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        callbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
}