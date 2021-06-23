package com.example.a99minstest.sys.di.components;

import com.example.a99minstest.data.datasources.web.CodesMexWeb;
import com.example.a99minstest.sys.di.modules.Network2Module;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = Network2Module.class)
public interface Framework2Component {

    void inject(CodesMexWeb codesMexWeb);

}
