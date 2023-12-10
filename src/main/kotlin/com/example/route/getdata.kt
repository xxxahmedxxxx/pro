package com.example.route

import com.example.model.data
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val apidata= listOf(
    data(key = "Electrical fires 1", value = "اخراج جميع من في مبني او منزل واتصال بي مطافي والاسعاف فورا "),
    data(key = "Electrical fires 2", value = "عدم استخدام الماء في إطفاء حرائق الكهرباء"),
    data(key = "Electrical fires 3", value = "العثور على الجهاز الذي تسبب في  الحريق الكهربائي،  فصل التيار عنه على الفور "),
    data(key = "Electrical fires 4", value =  "إذا كانت النار المشتعلة بسيطة  يمكنك إخمادها عن طريق إزالة باستخدام الملابس أو من خلال بطانية ثقيلة يتم إلقائها على مصدر النار"),
    data(key = "Electrical fires 5", value = "استخدام طفايه حريق لحين وصول المطافي "),
    data(key = "Electrical fires 6", value = "يجب إغلاق الباب حال المغادرة وذلك لاحتواء النار"),


    data(key = "Gasoline fires 1", value = "اتصل بالطوارئ واطلب المساعدة الطبية على الفور"),
    data(key = "Gasoline fires 2", value = "حذر الآخرين في المنطقة وحثهم على الابتعاد."),
    data(key = "Gasoline fires 3", value ="لا تستخدم الماء لإطفاء حريق البنزين، لأنه يمكن أن يزيد من انتشار اللهب"),
    data(key = "Gasoline fires 4", value = "استخدم وسائل إطفاء مناسبة مثل الرغوة الكيميائية الخاصة بإطفاء حرائق السوائل القابلة للاشتعال"),
    data(key = "Gasoline fires 5", value = "استخدم جهاز إطفاء الحريق إذا كان متاحًا وكان يستخدم نوعًا مناسبًا من وسائل الإطفاء"),
    data(key = "Gasoline fires 6", value = "استخدام طفاية حريق "),
    data(key = "Gasoline fires 7", value = "إذا كنت تستخدم بطانية إطفاء، ضعها بعناية فوق اللهب لإخماد الحريق"),
    data(key = "Gasoline fires 8", value = "قم بتجنب إدخال الهواء أو توفير الأكسجين للحريق، حيث يمكن أن يزيد هذا من شدة اللهب"),
    data(key = "Gasoline fires 9", value =  "ابتعد عن منطقة الحريق بأمان. حاول الابتعاد على بعد مسافة آمنة لتجنب التعرض للحرارة الشديدة والدخان الضار"),
    data(key = "Gasoline fires 10", value ="إذا كان هناك رياح، توجه بها لتجنب انتشار الدخان واللهب"),
    data(key = "Gasoline fires 11", value =  "تجنب العودة إلى مكان الحريق حتى بعد إطفائه لتجنب الخطر"),
    data(key = "Gasoline fires 12", value = "تأكد من أنك في مكان آمن وحافظ على سلامتك الشخصية"),

    data(key = "Oil fires 1", value = "اتصل بالطوارئ واطلب المساعدة الطبية على الفور"),
    data(key = "Oil fires 2", value = "حذر الآخرين في المنطقة وحثهم على الابتعاد."),
    data(key = "Oil fires 3", value =  "لا تستخدم الماء لإطفاء حريق البنزين، لأنه يمكن أن يزيد من انتشار اللهب"),
    data(key = "Oil fires 4", value = "استخدم وسائل إطفاء مناسبة مثل الرغوة الكيميائية الخاصة بإطفاء حرائق السوائل القابلة للاشتعال"),
    data(key = "Oil fires 5", value = "استخدم جهاز إطفاء الحريق إذا كان متاحًا وكان يستخدم نوعًا مناسبًا من وسائل الإطفاء"),
    data(key = "Oil fires 6", value = "استخدام طفاية حريق "),
    data(key = "Oil fires 7", value = "إذا كنت تستخدم بطانية إطفاء، ضعها بعناية فوق اللهب لإخماد الحريق"),
    data(key = "Oil fires 8", value =  "قم بتجنب إدخال الهواء أو توفير الأكسجين للحريق، حيث يمكن أن يزيد هذا من شدة اللهب"),
    data(key = "Oil fires 9", value ="ابتعد عن منطقة الحريق بأمان. حاول الابتعاد على بعد مسافة آمنة لتجنب التعرض للحرارة الشديدة والدخان الضار"),
    data(key = "Oil fires 10", value = "إذا كان هناك رياح، توجه بها لتجنب انتشار الدخان واللهب"),
    data(key = "Oil fires 11", value =  "تجنب العودة إلى مكان الحريق حتى بعد إطفائه لتجنب الخطر"),
    data(key = "Oil fires 12", value = "تأكد من أنك في مكان آمن وحافظ على سلامتك الشخصية"),

    data(key = "Chemical fires 1", value = "ارتدِ القفازات  أزل المواد الكيميائية الجافة "),
    data(key = "Chemical fires 2", value = "رمي اي شي ملامس لمده الكميائي"),
    data(key = "Chemical fires 3", value = "تخلص من المواد الكيميائية عن طريق الشطف بالماء لمدة 20 دقيقة على الأقل تحت الدش . واحرص على أن تحمي عينيك من التلوث الكيميائي"),
    data(key = "Chemical fires 4", value = "ضع ضمادة طبيه  على الحرق. احرص على تغطية. ولفها على نحو فضفاض لتجنب الضغط على الجلد المحروق."),
    data(key = "Chemical fires 5", value = "إذا استمر شعورك بالحرقان، فاشطف المنطقة المصابة مرة أخرى لبضع دقائق"),
    data(key = "Chemical fires 6", value = "الذهاب الي  اقرب مستشفي "),

    data(key = "Drowning 1", value = "استدعاء الإسعاف أو اتصل بالطوارئ"),
    data(key = "Drowning 2", value ="إذا كنت في مكان آمن ويمكنك الوصول إليه، قم بسحب الشخص المصاب بسرعة إلى مكان آمن"),
    data(key = "Drowning 3", value = "تجنب الدخول في المياه إذا كانت هناك خطورة على سلامتك و انتظر شخص مختص "),
    data(key = "Drowning 4", value =  "تحقق من وعي الشخص المصاب. اطلب منه أن يتكلم أو أن يُظهِر علامات وعي، مثل الحركة أو الاستجابة للمؤثرات الخارجية"),
    data(key = "Drowning 5", value = "إذا كان الشخص لا يتنفس، قم ببدء إجراءات الإنعاش القلبي الرئوي (CPR) إذا كنت مدربًا عليه"),
    data(key = "Drowning 6", value = "إذا كنت غير مدرب على إجراءات الإنعاش، قم بضغط على الصدر بمعدل 100-120 ضغطة في الدقيقة، مع تقديم ضغط بعمق حوالي 5 سم (2 بوصة)"),
    data(key = "Drowning 7", value = " كان الشخص يتنفس، قم بتوجيهه إلى وضعية الجانب للتخلص من الماء المتبقي في الرئتين"),
    data(key = "Drowning 8", value =  "غطِ الشخص ببطانية أو ملابس جافة للمساعدة في الحفاظ على الحرارة الجسدية"),
    data(key = "Drowning 9", value =  "بمجرد إجراء الإسعافات الأولية، قدم الشخص المصاب للرعاية الطبية في أسرع وقت ممكن"),
    data(key = "Drowning 10", value = "مهم جداً أن يتم توفير الإسعافات الأولية من قبل أشخاص مدربين على هذه العمليات. في حالة الغرق، يمكن أن تكون الاستجابة السريعة حاسمة لزيادة فرص النجاة والتعافي"),


    data(key = "Food poisoning 1", value = "من الضروري الاستراحة وتجنب النشاط الشاق للمساعدة في تقوية الجسم والتعافي"),
    data(key = "Food poisoning 2", value = "شرب الكثير من السوائل يساعد في تجنب الجفاف وتعزيز عملية التخلص من السموم"),
    data(key = "Food poisoning 3", value = "تجنب تناول الأطعمة الصعبة أو الصلبة التي يمكن أن تجعل الوضع أسوأ"),
    data(key = "Food poisoning 4", value =  "يمكن استخدام بعض العلاجات الطبيعية مثل شرب مغلي الزنجبيل لتهدئة المعدة"),
    data(key = "Food poisoning 5", value = "إذا استمرت الأعراض أو تفاقمت، يجب عليك الاتصال بالطبيب. في بعض الحالات، قد يكون من الضروري تلقي العناية الطبية"),
    data(key = "Food poisoning 6", value =  "يجب تجنب تناول أي أدوية دون استشارة الطبيب، إلا إذا كان هناك توصية خاصة"),
    data(key = "Food poisoning 7", value =  "إذا كنت قادرًا على تحديد نوع الطعام أو المشروب الذي قد تسبب في التسمم، فقد يكون ذلك مفيدًا لتجنب تناوله في المستقبل وللإبلاغ عن الحالة للسلطات الصحية"),
    data(key = "Food poisoning 8", value =  "يجب عليك تجنب التواصل مع الأشخاص الآخرين قدر الإمكان لتجنب نقل العدوى"),

    data(key = "Snake bites 1",value="اتصل بفريق الطوارئ على الفور"),
    data(key = "Snake bites 2",value="حاول البقاء هادئًا وتهدئة الشخص المصاب. الهدوء يساعد في تقليل سرعة انتشار السم"),
    data(key = "Snake bites 3",value="إذا كان ذلك آمنًا وممكنًا، حاول تحديد نوع الثعبان. يمكن أن يكون ذلك مفيدًا لتحديد العلاج الصحيح"),
    data(key = "Snake bites 4",value="قم بتقديم دعم للجزء المصاب وحد من حركة المنطقة المصابة. يمكن أن يساعد التقليل من الحركة في تقليل انتشار السم"),
    data(key = "Snake bites 5",value="قم بإزالة المجوهرات من المنطقة المصابة قبل أن تبدأ في الانتفاخ"),
    data(key = "Snake bites 6",value="إذا كان ذلك آمنًا، رفع المنطقة المصابة إلى أعلى، ولكن لا تضع الضغط الزائد على المنطقة"),
    data(key = "Snake bites 7",value="تجنب محاولة شفط السم بالفم. هذا لا يقلل من فعالية السم ويمكن أن يزيد من خطورة الإصابة"),
    data(key = "Snake bites 8",value="لا تقم بوضع الثلج على المنطقة المصابة. لا ينصح به لعلاج لدغات الثعابين"),
    data(key = "Snake bites 9",value="مراقبة الأعراض وتوجيه الشخص المصاب للجلوس أو الاستلقاء بموضع مريح"),
    data(key = "Snake bites 10",value="تذكر أنه يجب الحصول على الرعاية الطبية الفورية بمجرد حدوث لدغة الثعبان. لا تحاول علاج الدغة بمفردك، بل اعتمد على الفريق الطبي المحترف لتقديم العلاج اللازم وتقييم الحالة"),


    data(key = "Scorpion stings 1", value =  "قم بالابتعاد عن مصدر اللسعة وتأكد من إزالة العقرب إذا كان لا يزال ملتصقًا بالجلد"),
    data(key = "Scorpion stings 2", value = "احفظ العقرب إذا كان آمنًا للتعرف على نوعه"),
    data(key = "Scorpion stings 3", value = "قم بغسل مكان اللسعة بالماء والصابون لتقليل فرص العدوى"),
    data(key = "Scorpion stings 4", value = "يمكن تطبيق كيس ثلج أو ماء بارد على مكان اللسعة لتقليل الألم والتورم. ولكن تجنب وضع الثلج مباشرة على الجلد، استخدم قطعة قماش للف وسائل التبريد"),
    data(key = "Scorpion stings 5", value = "قم بتثبيت المنطقة المصابة بواسطة شريط للحد من الحركة وتقليل انتشار السم"),
    data(key = "Scorpion stings 6", value =  "يمكن تناول مسكنات الألم التي تحتوي على الباراسيتامول أو الإيبوبروفين بناءً على توجيهات الطبيب"),
    data(key = "Scorpion stings 7", value ="قم بمراقبة الأعراض. إذا كانت هناك أعراض خطيرة مثل صعوبة في التنفس أو انخفاض في ضغط الدم، فهذا يتطلب العناية الطبية الفورية"),
    data(key = "Scorpion stings 8", value =  " يجب على الشخص الذي تعرض للسعة العقرب البحث عن الرعاية الطبية على الفور. تكون لسعات العقارب قدرة على أن تكون سامة وتتطلب تقييمًا وعلاجًا متخصصين"),

    data(key = "Earthquake in the car 1", value = "ابحث عن مكان آمن للتوقف مثل مكان خالٍ من الأشجار أو المباني"),
    data(key = "Earthquake in the car 2", value = "تجنب التوقف تحت الأنفاق أو الكباري حيث يمكن أن تكون هناك انهيارات"),
    data(key = "Earthquake in the car 3", value = "تجنب التوقف تحت الكتل الكبيرة أو المباني المتهدمة حيث يمكن أن تكون هناك خطورة من الانهيار"),
    data(key = "Earthquake in the car 4", value =  "قلل من السرعة تدريجيًا وابتعد عن حركات القيادة الحادة"),
    data(key = "Earthquake in the car 5", value =  "تجنب الكباري العالية أو المناطق التي يمكن أن تكون عرضة للانهيار"),
    data(key = "Earthquake in the car 6", value =  "انخرط في المركبة وحافظ على رأسك وعنقك في مكان آمن"),
    data(key = "Earthquake in the car 7", value = "تجنب الخروج من السيارة، حيث يمكن أن تكون هناك خطورة من السقوط الأشياء"),
    data(key = "Earthquake in the car 8", value = "تجنب التوقف في الأماكن المفتوحة حيث يمكن أن يتساقط الأشياء على السيارة"),
    data(key = "Earthquake in the car 9", value =  "استمع إلى الأخبار عبر الراديو أو الهاتف لتلقي المعلومات حول الزلزال والتوجيهات الرسمية"),
    data(key = "Earthquake in the car 10", value = "بمجرد توقف الزلزال، تحقق من سلامة نفسك والآخرين، وقدم المساعدة إذا كنت في موقع يمكنك من ذلك"),


    data(key = "During the earthquake 1", value = "انخرط على الأرض واستلقِ على يديك وركبتيك لتقليل فرص التعرض للإصابات"),
    data(key = "During the earthquake 2", value = "ابتعد عن النوافذ والأسطح الزجاجية، وأي شيء يمكن أن يسقط عليك"),
    data(key = "During the earthquake 3", value = "تجنب التحرك داخل المباني أثناء الزلزال، حيث يمكن أن يكون هناك خطر من السقوط."),
    data(key = "During the earthquake 4", value = "إذا كنت قريبًا من طاولة قوية، اختبأ تحتها للحماية من السقوط الأشياء"),
    data(key = "During the earthquake 5", value = "تجنب استخدام السلالم أثناء الزلزال، لأنها قد تكون غير آمنة"),


    data(key = "After the earthquake 1", value = "تحقق من سلامة نفسك والأشخاص المحيطين بك"),
    data(key = "After the earthquake 2", value ="ابقى في مكان آمن حتى يتضح أن الخطر قد انتهى تمامًا"),
    data(key = "After the earthquake 3", value = "تجنب الأماكن القريبة من المباني المتضررة أو الأسلاك الكهربائية المكسورة"),
    data(key = "After the earthquake 4", value =  "قم بتقييم الأضرار في المبنى وتجنب دخول المباني التي تظهر عليها علامات تلف خطير"),
    data(key = "After the earthquake 5", value = "استمع للتقارير الإخبارية أو الإعلانات الرسمية لتلقي التوجيهات بشأن مواقع الإغاثة والتحذيرات"),
    data(key = "After the earthquake 6", value =  "قدم المساعدة للأشخاص الذين قد يحتاجون إلى عناية طبية"),
    data(key = "After the earthquake 7", value =  "كن حذرًا من الاهتزازات الثانوية أو الهزات الارتدادية. انخرط في مكان آمن حتى تتوقف تمامً")








    )


fun Route.getdata(){
    get("/data"){
call.respond(
    HttpStatusCode.OK,
    apidata

)


    }
}