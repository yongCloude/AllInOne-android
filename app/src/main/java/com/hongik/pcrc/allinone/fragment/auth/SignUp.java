package com.hongik.pcrc.allinone.fragment.auth;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.hongik.pcrc.allinone.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp extends Fragment {

    public static String TAG = "SignUp";

    public interface Callbacks {
        void onBackArrowSelected();
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
    private TextView signUpTitle;

    LinearLayout containerId;
    private EditText editTextId;
    private TextView textViewIdAlert;

    LinearLayout containerEmailConfirm;
    private EditText editTextEmailAuthNumber;
    private Button requestAuthNumber;
    private Button checkAuthNumber;
    private TextView textViewEmailAlert;

    LinearLayout containerPassword;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private TextView textViewPasswordAlert;

    LinearLayout containerPhoneNumber;
    private EditText editTextPhoneNumber;
    private TextView textViewPhoneNumberAlert;

    LinearLayout containerName;
    private EditText editTextName;

    LinearLayout containerGender;
    private String[] items;
    private Spinner spinnerGender;

    private Button signUpAccept;



    public SignUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUp.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp newInstance(String param1, String param2) {
        SignUp fragment = new SignUp();
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

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        backArrow = view.findViewById(R.id.signup_back_button);
        signUpTitle = view.findViewById(R.id.signup_title);

        initSignUpUserInteractView(inflater, view);


        backArrow.setOnClickListener(v -> {
            callbacks.onBackArrowSelected();
        });


        editTextId.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // TODO: 2022/07/02 아이디 확인 버튼 눌렀을 때 이메일 형식 맞을 경우 다음으로 넘어가도록 하기
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    containerEmailConfirm.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        requestAuthNumber.setOnClickListener(v -> {

        });

        checkAuthNumber.setOnClickListener(v -> {
            // TODO: 2022/07/03 이메일 인증 완료시 다음으로 넘어가기
            containerEmailConfirm.removeAllViews();
            containerPassword.setVisibility(View.VISIBLE);
        });

        editTextPasswordConfirm.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    containerName.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        editTextName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_DONE){
                    containerGender.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, items);
        spinnerGender.setAdapter(adapter);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                containerPhoneNumber.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editTextPhoneNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                signUpAccept.setVisibility(View.VISIBLE);
                return false;
            }
        });

        signUpAccept.setOnClickListener(v -> {
            // TODO: 2022/07/03 회원가입 정보 전송하기

        });





        return view;
    }
    @Override
    public void onStart() {
        super.onStart();


        TextWatcher idTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: 2022/07/01 이메일 형식 예외처리

            }
        };

        TextWatcher emailAuthNumberTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editTextId.addTextChangedListener(idTextWatcher);
        editTextEmailAuthNumber.addTextChangedListener(emailAuthNumberTextWatcher);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }



    private void initSignUpUserInteractView(LayoutInflater inflater, View view) {
        // ID part -> exposed to user at first

        containerId = view.findViewById(R.id.signup_container_id);
        inflater.inflate(R.layout.item_sign_up_id, containerId, true);
        editTextId = view.findViewById(R.id.signup_id_input);
        textViewIdAlert = view.findViewById(R.id.signup_id_alert);

        // Email part
        containerEmailConfirm = view.findViewById(R.id.signup_container_email_confirm);
        inflater.inflate(R.layout.item_sign_up_email_confirm, containerEmailConfirm, true);
        containerEmailConfirm.setVisibility(View.GONE);
        editTextEmailAuthNumber = view.findViewById(R.id.signup_auth_email_input);
        requestAuthNumber = view.findViewById(R.id.signup_auth_email_request_button);
        checkAuthNumber = view.findViewById(R.id.signup_auth_email_confirm_button);

        // Password part
        containerPassword = view.findViewById(R.id.signup_container_password);
        inflater.inflate(R.layout.item_sign_up_password, containerPassword, true);
        containerPassword.setVisibility(View.GONE);
        editTextPassword = view.findViewById(R.id.signup_password_input);
        editTextPasswordConfirm = view.findViewById(R.id.signup_password_confirm_input);
        textViewPasswordAlert = view.findViewById(R.id.signup_password_alert);

        // Name part
        containerName = view.findViewById(R.id.signup_container_name);
        inflater.inflate(R.layout.item_sign_up_name, containerName, true);
        containerName.setVisibility(View.GONE);
        editTextName = view.findViewById(R.id.signup_name_input);

        // Gender part
        containerGender = view.findViewById(R.id.signup_container_gender);
        inflater.inflate(R.layout.item_sign_up_gender, containerGender, true);
        containerGender.setVisibility(View.GONE);
        spinnerGender = view.findViewById(R.id.signup_gender);
        items = getResources().getStringArray(R.array.gender);

        // Phone number part
        containerPhoneNumber = view.findViewById(R.id.signup_container_phone_number);
        inflater.inflate(R.layout.item_sign_up_phone_number, containerPhoneNumber, true);
        containerPhoneNumber.setVisibility(View.GONE);
        editTextPhoneNumber = view.findViewById(R.id.signup_phone_number_input);
        textViewPhoneNumberAlert = view.findViewById(R.id.signup_phone_number_alert);

        signUpAccept = view.findViewById(R.id.signup_accept);
        signUpAccept.setVisibility(View.GONE);
    }
}