package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ArrayList<RunGroup> runGroups = new ArrayList<>();
    private BasicMeasure.Measurer mMeasurer = null;
    private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    ArrayList<RunGroup> mGroups = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i2, int i3, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup(widgetRun, i3);
                arrayList.add(runGroup);
            }
            widgetRun.runGroup = runGroup;
            runGroup.add(widgetRun);
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency, i2, 0, dependencyNode2, arrayList, runGroup);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i2, 1, dependencyNode2, arrayList, runGroup);
                }
            }
            if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i2, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                if (dependencyNode3 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode3, i2, 0, dependencyNode2, arrayList, runGroup);
            }
            for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                if (dependencyNode4 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode4, i2, 1, dependencyNode2, arrayList, runGroup);
            }
            if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                while (it.hasNext()) {
                    applyGroup(it.next(), i2, 2, dependencyNode2, arrayList, runGroup);
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int width;
        int height;
        int i2;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
                            if (next.mMatchConstraintDefaultWidth == 0) {
                                next.mMatchConstraintDefaultWidth = 3;
                            }
                            if (next.mMatchConstraintDefaultHeight == 0) {
                                next.mMatchConstraintDefaultHeight = 3;
                            }
                        }
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour;
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour2;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour4;
                horizontalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour5;
                verticalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                if ((dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int width2 = next.getWidth();
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        width = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        width = width2;
                    }
                    int height2 = next.getHeight();
                    if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        height = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        height = height2;
                    }
                    measure(next, dimensionBehaviour4, width, dimensionBehaviour5, height);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        int i3 = next.mMatchConstraintDefaultWidth;
                        if (i3 == 3) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour5 == dimensionBehaviour6) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            int height3 = next.getHeight();
                            int i4 = (int) ((height3 * next.mDimensionRatio) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour7, i4, dimensionBehaviour7, height3);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else if (i3 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                measure(next, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour5, next.getHeight());
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        int i5 = next.mMatchConstraintDefaultHeight;
                        if (i5 == 3) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 == dimensionBehaviour8) {
                                measure(next, dimensionBehaviour8, 0, dimensionBehaviour8, 0);
                            }
                            int width3 = next.getWidth();
                            float f2 = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                f2 = 1.0f / f2;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour9, width3, dimensionBehaviour9, (int) ((width3 * f2) + 0.5f));
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i5 == 1) {
                            measure(next, dimensionBehaviour4, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i5 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr3[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                measure(next, dimensionBehaviour4, next.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour10 && dimensionBehaviour5 == dimensionBehaviour10) {
                        int i6 = next.mMatchConstraintDefaultWidth;
                        if (i6 == 1 || (i2 = next.mMatchConstraintDefaultHeight) == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            measure(next, dimensionBehaviour11, 0, dimensionBehaviour11, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i2 == 2 && i6 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviourArr4[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour12 == dimensionBehaviour13 || dimensionBehaviourArr4[0] == dimensionBehaviour13) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr5 = constraintWidgetContainer.mListDimensionBehaviors;
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = dimensionBehaviourArr5[1];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour14 == dimensionBehaviour15 || dimensionBehaviourArr5[1] == dimensionBehaviour15) {
                                    float f3 = next.mMatchConstraintPercentWidth;
                                    int height4 = (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f);
                                    ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                                    measure(next, dimensionBehaviour16, (int) ((f3 * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour16, height4);
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        int size = this.mGroups.size();
        long jMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jMax = Math.max(jMax, this.mGroups.get(i3).computeWrapSize(constraintWidgetContainer, i2));
        }
        return (int) jMax;
    }

    private void displayGraph() {
        Iterator<WidgetRun> it = this.mRuns.iterator();
        String strGenerateDisplayGraph = "digraph {\n";
        while (it.hasNext()) {
            strGenerateDisplayGraph = generateDisplayGraph(it.next(), strGenerateDisplayGraph);
        }
        String str = strGenerateDisplayGraph + "\n}\n";
        System.out.println("content:<<\n" + str + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i2, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i2, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i2, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i2, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i2, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        String str2;
        String str3;
        int i2 = chainRun.orientation;
        String str4 = "cluster_" + chainRun.widget.getDebugName();
        if (i2 == 0) {
            str2 = str4 + "_h";
        } else {
            str2 = str4 + "_v";
        }
        String str5 = "subgraph " + str2 + " {\n";
        Iterator<WidgetRun> it = chainRun.widgets.iterator();
        String strGenerateDisplayGraph = "";
        while (it.hasNext()) {
            WidgetRun next = it.next();
            String debugName = next.widget.getDebugName();
            if (i2 == 0) {
                str3 = debugName + "_HORIZONTAL";
            } else {
                str3 = debugName + "_VERTICAL";
            }
            str5 = str5 + str3 + ";\n";
            strGenerateDisplayGraph = generateDisplayGraph(next, strGenerateDisplayGraph);
        }
        return str + strGenerateDisplayGraph + (str5 + "}\n");
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        boolean z;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() && dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
            return str;
        }
        String str2 = str + nodeDefinition(widgetRun);
        boolean zIsCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String strGenerateDisplayNode = generateDisplayNode(dependencyNode2, zIsCenteredConnection, generateDisplayNode(dependencyNode, zIsCenteredConnection, str2));
        boolean z2 = widgetRun instanceof VerticalWidgetRun;
        if (z2) {
            strGenerateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, zIsCenteredConnection, strGenerateDisplayNode);
        }
        if ((widgetRun instanceof HorizontalWidgetRun) || (((z = widgetRun instanceof ChainRun)) && ((ChainRun) widgetRun).orientation == 0)) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    strGenerateDisplayNode = strGenerateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    strGenerateDisplayNode = strGenerateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
                }
            } else if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                String debugName = widgetRun.widget.getDebugName();
                String str3 = "\n" + debugName + "_HORIZONTAL -> " + debugName + "_VERTICAL;\n";
            }
        } else if (z2 || (z && ((ChainRun) widgetRun).orientation == 1)) {
            ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    strGenerateDisplayNode = strGenerateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    strGenerateDisplayNode = strGenerateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
                }
            } else if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                String debugName2 = widgetRun.widget.getDebugName();
                String str4 = "\n" + debugName2 + "_VERTICAL -> " + debugName2 + "_HORIZONTAL;\n";
            }
        }
        return widgetRun instanceof ChainRun ? generateChainDisplayGraph((ChainRun) widgetRun, strGenerateDisplayNode) : strGenerateDisplayNode;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z, String str) {
        for (DependencyNode dependencyNode2 : dependencyNode.targets) {
            String str2 = ("\n" + dependencyNode.name()) + " -> " + dependencyNode2.name();
            if (dependencyNode.margin > 0 || z || (dependencyNode.run instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.margin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.margin + "\"";
                    if (z) {
                        str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                }
                if (z) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.run instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            str = str + (str2 + "\n");
        }
        return str;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        Iterator<DependencyNode> it = dependencyNode.targets.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i2++;
            }
        }
        Iterator<DependencyNode> it2 = dependencyNode2.targets.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode) {
                i3++;
            }
        }
        return i2 > 0 && i3 > 0;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i2;
        measure.verticalDimension = i3;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.widget.getDebugName();
        ConstraintWidget constraintWidget = widgetRun.widget;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = !z ? constraintWidget.getHorizontalDimensionBehaviour() : constraintWidget.getVerticalDimensionBehaviour();
        RunGroup runGroup = widgetRun.runGroup;
        if (z) {
            str = debugName + "_VERTICAL";
        } else {
            str = debugName + "_HORIZONTAL";
        }
        String str5 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
        if (z) {
            String str6 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str6 = str6 + " BGCOLOR=\"green\"";
            }
            str2 = str6 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        } else {
            String str7 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str7 = str7 + " BGCOLOR=\"green\"";
            }
            str2 = str7 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        }
        String str8 = str2 + "    <TD BORDER=\"1\" ";
        if (widgetRun.dimension.resolved && !widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"green\" ";
        } else if (widgetRun.dimension.resolved && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"lightgray\" ";
        } else if (!widgetRun.dimension.resolved && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"yellow\" ";
        }
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            str8 = str8 + "style=\"dashed\"";
        }
        if (runGroup != null) {
            str3 = " [" + (runGroup.groupIndex + 1) + "/" + RunGroup.index + "]";
        } else {
            str3 = "";
        }
        String str9 = str8 + ">" + debugName + str3 + " </TD>";
        if (z) {
            String str10 = str9 + "    <TD ";
            if (z && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                str10 = str10 + " BGCOLOR=\"green\"";
            }
            String str11 = (str10 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
            if (widgetRun.end.resolved) {
                str11 = str11 + " BGCOLOR=\"green\"";
            }
            str4 = str11 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        } else {
            String str12 = str9 + "    <TD ";
            if (widgetRun.end.resolved) {
                str12 = str12 + " BGCOLOR=\"green\"";
            }
            str4 = str12 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        }
        return (str4 + "  </TR></TABLE>") + ">];\n";
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Iterator<RunGroup> it2 = this.mGroups.iterator();
            while (it2.hasNext()) {
                it2.next().defineTerminalWidgets(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2;
        boolean z3 = z & true;
        boolean z4 = false;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.horizontalRun.reset();
                next.verticalRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x = this.container.getX();
        int y = this.container.getY();
        this.container.horizontalRun.start.resolve(x);
        this.container.verticalRun.start.resolve(y);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z3) {
                Iterator<WidgetRun> it2 = this.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().supportsWrapComputation()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z3 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
        if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = this.container.getWidth() + x;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x);
            measureWidgets();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.container.getHeight() + y;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y);
            }
            measureWidgets();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.container || next2.resolved) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it4 = this.mRuns.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z4 = true;
                break;
            }
            WidgetRun next3 = it4.next();
            if (z2 || next3.widget != this.container) {
                if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.mNeedBuildGraph) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i2) {
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z3 = z & true;
        boolean z4 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
        int x = this.container.getX();
        int y = this.container.getY();
        if (z3 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i2 && !next.supportsWrapComputation()) {
                    z3 = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z3 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z3 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i2 == 0) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = this.container.getWidth() + x;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.container.getHeight() + y;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y);
                z2 = true;
            }
            z2 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = this.mRuns.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == i2 && (next2.widget != this.container || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = this.mRuns.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z4 = true;
                break;
            }
            WidgetRun next3 = it3.next();
            if (next3.orientation == i2 && (z2 || next3.widget != this.container)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)) {
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z4;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        DimensionDependency dimensionDependency;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i2 = next.mMatchConstraintDefaultWidth;
                int i3 = next.mMatchConstraintDefaultHeight;
                boolean z2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                boolean z3 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                boolean z4 = dimensionDependency3.resolved;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour3, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                    next.measured = true;
                } else if (z3 && z) {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.verticalRun.dimension.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z2) {
                    measure(next, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, next.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, next.verticalRun.dimension.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
    }
}
