package com.journaldev.androidarcoredistancecamera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.Pose;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity implements Scene.OnUpdateListener {


    private static final double MIN_OPENGL_VERSION = 3.0;
    private static final String TAG = MainActivity.class.getSimpleName();

    //private final SnackbarHelper messageSnackbarHelper = new SnackbarHelper();
    private final float[] modelMatrix = new float[16];
    private float[] modelMatrixAnt = new float[16];
    int aux = 1;
    float distance;

    private ArFragment arFragment;
    private AnchorNode currentAnchorNode;
    private TextView tvDistance;
    ModelRenderable cubeRenderable;
    private Anchor currentAnchor = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkIsSupportedDeviceOrFinish(this)) {
            Toast.makeText(getApplicationContext(), "Device not supported", Toast.LENGTH_LONG).show();
        }

        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        tvDistance = findViewById(R.id.tvDistance);


        initModel();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            if (cubeRenderable == null)
                return;

            // Creating Anchor.
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            clearAnchor();

            currentAnchor = anchor;
            currentAnchorNode = anchorNode;


            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setRenderable(cubeRenderable);
            node.setParent(anchorNode);
            arFragment.getArSceneView().getScene().addOnUpdateListener(this);
            arFragment.getArSceneView().getScene().addChild(anchorNode);
            node.select();


        });


    }

    public boolean checkIsSupportedDeviceOrFinish(final Activity activity) {

        String openGlVersionString =
                ((ActivityManager) Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE)))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }

    private void initModel() {
        MaterialFactory.makeTransparentWithColor(this, new Color(android.graphics.Color.RED))
                .thenAccept(
                        material -> {
                            Vector3 vector3 = new Vector3(0.05f, 0.01f, 0.01f);
                            cubeRenderable = ShapeFactory.makeCube(vector3, Vector3.zero(), material);
                            cubeRenderable.setShadowCaster(false);
                            cubeRenderable.setShadowReceiver(false);
                        });
    }

    private void clearAnchor() {
        currentAnchor = null;


        if (currentAnchorNode != null) {
            arFragment.getArSceneView().getScene().removeChild(currentAnchorNode);
            currentAnchorNode.getAnchor().detach();
            currentAnchorNode.setParent(null);
            currentAnchorNode = null;
        }
    }

    @Override
    public void onUpdate(FrameTime frameTime) {
        Frame frame = arFragment.getArSceneView().getArFrame();
        Log.d("API123", "onUpdateframe... current anchor node " + (currentAnchorNode == null));

        if (currentAnchorNode != null) {
            Pose objectPose = currentAnchor.getPose();
            Pose cameraPose = frame.getCamera().getPose();
            ///////////////////////////////
            objectPose.toMatrix(modelMatrix, 0);
            if (!areSame(modelMatrix,modelMatrixAnt)) {
                if (aux == 1) {
                    //1rst Anchor --- Save current modelMatrix as modelMatrixAnt
                    //Log.i("key2", "modelMatrix = " + Arrays.toString(modelMatrixAnt));
                    System.arraycopy(modelMatrix, 0, modelMatrixAnt, 0, 16);
                    Log.i("key1", "modelMatrix = " + Arrays.toString(modelMatrix));
                    Log.i("key3", "pose = " + objectPose.toString());
                    Log.i("key2", aux + "st Anchor" );
                    //Log.i("key3", "pose1 =" + pose1.toString());
                    //Log.i("key6", modelMatrix[13] + "modelMatrix[13]" );
                    aux=aux+1;
                } else if (aux == 2) {
                    //2nd Anchor --- Calculate+Show distance on screen
                    Log.i("key2", aux + "º Anchor" );
                    distance = distance2Points(modelMatrix, modelMatrixAnt);
                    //distance = 10;
                    String distanceString = String.valueOf(distance);
                    Log.i("key4", "distance = " + distanceString);
                    tvDistance.setText("Distance: " + distanceString + " m.");
                    //aux=0;
                }
            }
            /*
            ///////////////////////////////////
            float dx = objectPose.tx() - cameraPose.tx();
            float dy = objectPose.ty() - cameraPose.ty();
            float dz = objectPose.tz() - cameraPose.tz();

            ///Compute the straight-line distance.
            float distanceMeters = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
            tvDistance.setText("Distance from camera: " + distanceMeters + " metres");
            */

            /*float[] distance_vector = currentAnchor.getPose().inverse()
                    .compose(cameraPose).getTranslation();
            float totalDistanceSquared = 0;
            for (int i = 0; i < 3; ++i)
                totalDistanceSquared += distance_vector[i] * distance_vector[i];*/
        }
    }
    //Calculate distancia between 2 points on same frame
    private float distance2Points(float[] array1, float[] array2) {
        float distx1 = array1[13];
        float disty1 = array1[14];
        float distz1 = array1[15];
        float distx2 = array2[13];
        float disty2 = array2[14];
        float distz2 = array2[15];

        float distance = (float) Math.sqrt(pow(distx1 - distx2, 2) + pow(disty1 - disty2, 2) + pow(distz1 - distz2, 2));
        return distance;
    }

    //Compare Matrix
    static boolean areSame(float A[], float B[]) {
        int i;
        for (i = 0; i < 16; i++)
            if (A[i] != B[i])
                return false;
        return true;
    }
}
