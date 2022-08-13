# spring-cache
##一、相关配置
<table>
<tr>
<th>注解</th>
<th>作用范围</th>
<th>功能描述</th>
<th>属性</th>
<th>属性描述</th>
</tr>
<tr>
<td rowspan="2">@EnableCaching</td>
<td rowspan="2">配置类</td>
<td rowspan="2">开启缓存功能</td>
<td>proxyTargetClass</td>
<td>代理方式：false代表jdk代理，true代表使用cglib代理</td>
</tr>
<tr>
<td>mode</td>
<td>指定AOP的模式，当值为AdviceMode.PROXY时表示使用Spring aop,当值为当值为AdviceMode.ASPECTJ时，表示使用AspectJ。</td>
</tr>
<tr>
<tr>
<td rowspan="9">@Cacheable</td>
<td rowspan="9">类或方法</td>
<td rowspan="9">赋予缓存功能</td>
<td>value</td>
<td>指定Cache名称</td>
</tr>
<tr>
<td>cacheNames</td>
<td>同value</td>
</tr>
<tr>
<td>key</td>
<td>自定义key</td>
</tr>
<tr>
<td>condition</td>
<td>控制缓存的使用条件，condition属性默认为空，表示将缓存所有的调用情形，其值是通过spel表达式来指定的，当为
true时表示先尝试从缓存中获取；若缓存中不存在，则只需方法，并将方法返回值丢到缓存中；当为
false的时候，不走缓存、直接执行方法、并且返回结果也不会丢到缓存中。</td>
</tr>
<tr>
<td>unless</td>
<td>控制是否需要将结果丢到缓存中，前提是condition为空或者为true的情况下，unless才有效，condition为false的时候，unless无效，
unless为true，方法返回结果不会丢到缓存中；unless为false，方法返回结果会丢到缓存中。</td>
</tr>
<tr>
<td>keyGenerator</td>
<td>key生成策略</td>
</tr>
<tr>
<td>cacheManager</td>
<td>指定缓存控制器</td>
</tr>
<tr>
<td>cacheResolver</td>
<td>指定缓存解析器</td>
</tr>
<tr>
<td>sync</td>
<td>是否同步 从相同key加载值 的方法</td>
</tr>
<tr>
<td rowspan="9">@CachePut</td>
<td rowspan="9">类或方法</td>
<td rowspan="9">将结果放入缓存</td>
<td>value</td>
<td>指定Cache名称</td>
</tr>
<tr>
<td>cacheNames</td>
<td>同value</td>
</tr>
<tr>
<td>key</td>
<td>自定义key</td>
</tr>
<tr>
<td>condition</td>
<td>控制缓存的使用条件，condition属性默认为空，表示将缓存所有的调用情形，其值是通过spel表达式来指定的，当为
true时表示先尝试从缓存中获取；若缓存中不存在，则只需方法，并将方法返回值丢到缓存中；当为
false的时候，不走缓存、直接执行方法、并且返回结果也不会丢到缓存中。</td>
</tr>
<tr>
<td>unless</td>
<td>控制是否需要将结果丢到缓存中，前提是condition为空或者为true的情况下，unless才有效，condition为false的时候，unless无效，
unless为true，方法返回结果不会丢到缓存中；unless为false，方法返回结果会丢到缓存中。</td>
</tr>
<tr>
<td>keyGenerator</td>
<td>key生成策略</td>
</tr>
<tr>
<td>cacheManager</td>
<td>指定缓存控制器</td>
</tr>
<tr>
<td>cacheResolver</td>
<td>指定缓存解析器</td>
</tr>
<tr>
<td>sync</td>
<td>是否同步 从相同key加载值 的方法</td>
</tr>
<tr>
<td rowspan="9">@CacheEvict</td>
<td rowspan="9">类或方法</td>
<td rowspan="9">清理缓存</td>
<td>value</td>
<td>cache的名称</td>
</tr>
<tr>
<td>cacheNames</td>
<td>同value</td>
</tr>
<tr>
<td>key</td>
<td>key</td>
</tr>
<tr>
<td>keyGenerator</td>
<td>key生成策略</td>
</tr>
<tr>
<td>cacheManager</td>
<td>指定缓存控制器</td>
</tr>
<tr>
<td>cacheResolver</td>
<td>指定缓存解析器</td>
</tr>
<tr>
<td>condition</td>
<td>注解生效条件，同@CacheAble condition</td>
</tr>
<tr>
<td>allEntries</td>
<td>是否清理 cacheNames 指定的缓存中的所有缓存信息，默认是false， 可以将一个cache想象为一个HashMap，当 allEntries 为true的时候，相当于 HashMap.clear()，当 allEntries 为false的时候，只会干掉key对应的数据，相当于HashMap.remove(key)</td>
</tr>
<tr>
<td>beforeInvocation</td>
<td>何事执行清除操作（方法执行前 or 方法执行成功之后）,true：@CacheEvict 标注的方法执行之前，执行清除操作,false：@CacheEvict 标注的方法执行成功之后，执行清除操作，当方法弹出异常的时候，不会执 行清除操作</td>
</tr>
<tr>
<td rowspan="3">@Caching</td>
<td rowspan="3">缓存注解组</td>
<td rowspan="3">类上或方法</td>
<td>cacheable</td>
<td></td>
</tr>
<tr>
<td>put</td>
<td></td>
</tr>
<tr>
<td>evict</td>
<td></td>
</tr>
<tr>
<td>@CacheConfig</td>
<td>提取公共配置</td>
<td>类</td>
<td></td>
<td></td>
</tr>
</table>
key属性支持SpEL表达式；当我们没有指定该属性时，Spring将使用默认策略生成
key（org.springframework.cache.interceptor.SimpleKeyGenerator），默认会方法参数创建key。
Spring还为我们提供了一个root对象可以用来生成key，通过该root对象我们可以获取到以下信息。
<table>
<tr>
<th>属性名称</th>
<th>描述</th>
<th>示例</th>
</tr>
<tr>
<td>methodName</td>
<td>当前方法名</td>
<td>#root.methodName</td>
</tr>
<tr>
<td>method</td>
<td>当前方法</td>
<td>#root.method.name</td>
</tr>
<tr>
<td>target</td>
<td>当前被调用的对象</td>
<td>#root.target</td>
</tr>
<tr>
<td>targetClass</td>
<td>当前被调用的对象的class</td>
<td>#root.targetClass</td>
</tr>
<tr>
<td>args</td>
<td>当前方法参数组成的数组</td>
<td>#root.args[0]</td>
</tr>
<tr>
<td>caches</td>
<td>当前被调用的方法使用的Cache</td>
<td>#root.caches[0].name</td>
</tr>
</table>

ProxyCachingConfiguration

CacheInterceptor

BeanFactoryCacheOperationSourceAdvisor