package com.example.rapidrollclassic.fragments;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.rapidrollclassic.R;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);

        ArrayList<Integer> textViewIds = new ArrayList<>();
        textViewIds.add(R.id.textViewSound);
        textViewIds.add(R.id.textViewMusic);
        textViewIds.add(R.id.textViewSpeedMode);
        textViewIds.add(R.id.textViewGameControl);
        textViewIds.add(R.id.textViewBallColor);

        for (int id : textViewIds) {
            TextView textView = view.findViewById(id);
            if (textView != null) {
                setGradient(textView);
            }
        }

        return view;
    }

    private void setGradient(TextView textView) {
        // Явно указываем кастомный шрифт
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.montserrat_black);
        textView.setTypeface(typeface); // И передаем его во вью

        // Так, шейдер позволяет нам программно повесить на элемент цвет. так как у нас градиент,
        // надо указать стартовый и конечный цвета
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(),
                // Нули - это начальные координаты градиента - левый верхний в этом случае
                // 0 и текст гет сайз показывает координаты конечного цвета
                new int[]{
                        getResources().getColor(R.color.start_color),
                        getResources().getColor(R.color.end_color)
                }, null, Shader.TileMode.CLAMP); // Нулл тут для равномерного расположения цвета
        // Shader.TileMode.CLAMP - растягивает конечные цвета за пределы картинки чтобы увет был плавным
        textView.getPaint().setShader(textShader);
    }
}
