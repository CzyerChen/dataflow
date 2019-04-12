package com.dataflow.core.model.message;


import com.dataflow.core.constant.MediaSourceTypeEnum;

import java.util.Set;

/**
 * Desciption:参数抽象类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 12 16:22
 */

public abstract class PluginParameter extends Parameter {
    private final String pluginName;
    private final String pluginClass;
    private final String pluginListenerClass;
    private final Set<MediaSourceTypeEnum> supportedSourceTypes;
    private boolean perfStatistic;

    public PluginParameter() {
        this.pluginName = initPluginName();
        this.pluginClass = initPluginClass();
        this.pluginListenerClass = initPluginListenerClass();
        this.supportedSourceTypes = initSupportedSourceTypes();
    }

    public abstract String initPluginName();

    public abstract String initPluginClass();

    public abstract String initPluginListenerClass();

    public abstract Set<MediaSourceTypeEnum> initSupportedSourceTypes();

    public final String getPluginName() {
        return pluginName;
    }

    public final void setPluginName(String pluginName) {
    }

    public final String getPluginClass() {
        return pluginClass;
    }

    public final void setPluginClass(String pluginClass) {
    }

    public String getPluginListenerClass() {
        return pluginListenerClass;
    }

    public final void setPluginListenerClass(String pluginListenerClass) {
    }

    public final Set<MediaSourceTypeEnum> getSupportedSourceTypes() {
        return supportedSourceTypes;
    }

    public final void setSupportedSourceTypes() {
    }

    public boolean isPerfStatistic() {
        return perfStatistic;
    }

    public void setPerfStatistic(boolean perfStatistic) {
        this.perfStatistic = perfStatistic;
    }
}
