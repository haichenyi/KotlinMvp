package com.haichenyi.kotlinmvp.third.router

import javax.inject.Inject

class RouterIml @Inject constructor(private val routerReal: RouterReal) : RouterHelper by routerReal