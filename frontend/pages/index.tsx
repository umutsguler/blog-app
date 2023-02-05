import Link from 'next/link'

export default function Home() {
  return (
    <>
      <div className={'text-orange-600 px-6'}>Test</div>
        <div className="text-3xl font-bold underline text-orange-600">
            Hello world!
        </div>
        <Link
            href={{
                pathname: '/blog',
            }}
        >
            Blogs
        </Link>
    </>
  )
}
