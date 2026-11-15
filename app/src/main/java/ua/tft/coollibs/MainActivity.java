package ua.tft.coollibs; // ЗАМІНИ НА СВІЙ ПАКЕТ

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.flaviofaria.kenburnsview.KenBurnsView;

import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ініціалізація
        KenBurnsView kbvPoster = findViewById(R.id.kbvPoster);
        ShimmerFrameLayout shimmerContainer = findViewById(R.id.shimmerContainer);
        Button btnBuyTicket = findViewById(R.id.btnBuyTicket);
        KonfettiView konfettiView = findViewById(R.id.konfettiView);

        View tutorialOverlay = findViewById(R.id.tutorialOverlay);
        View tutorialCard = findViewById(R.id.tutorialCard);
        Button btnGotIt = findViewById(R.id.btnGotIt);

        // 1 & 2. Завантаження картинки через Glide у рухомий KenBurnsView
        String posterUrl = "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?q=80&w=1080&auto=format&fit=crop";
        Glide.with(this).load(posterUrl).centerCrop().into(kbvPoster);

        // Кнопка закриття нашої власної підказки (Онбординг)
        btnGotIt.setOnClickListener(v -> {
            // Ховаємо темний оверлей та картку підказки
            tutorialOverlay.setVisibility(View.GONE);
            tutorialCard.setVisibility(View.GONE);

        });

        // Дія при купівлі квитка
        btnBuyTicket.setOnClickListener(v -> {
            // 5. Випускаємо конфетті (Konfetti)
            EmitterConfig emitterConfig = new Emitter(100L, TimeUnit.MILLISECONDS).max(100);
            konfettiView.start(
                    new PartyFactory(emitterConfig)
                            .spread(360)
                            .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE))
                            .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                            .setSpeedBetween(0f, 30f)
                            .position(0.5, 0.5, 1, 1)
                            .build()
            );
        });
    }
}